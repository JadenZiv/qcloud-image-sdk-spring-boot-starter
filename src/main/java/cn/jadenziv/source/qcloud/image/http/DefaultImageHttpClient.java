package cn.jadenziv.source.qcloud.image.http;

import cn.jadenziv.source.qcloud.image.ClientConfig;
import cn.jadenziv.source.qcloud.image.exception.AbstractImageException;
import cn.jadenziv.source.qcloud.image.exception.ParamException;
import cn.jadenziv.source.qcloud.image.exception.ServerException;
import cn.jadenziv.source.qcloud.image.exception.UnknownException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import com.squareup.okhttp.Request.Builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author chengwu 封装Http发送请求类
 */
public class DefaultImageHttpClient extends AbstractImageHttpClient {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private OkHttpClient mOkHttpClient = new OkHttpClient();

    public DefaultImageHttpClient(ClientConfig config) {
        super(config);
    }

    @Override
    public void shutdown() {
        mOkHttpClient.getDispatcher().getExecutorService().shutdown();   //清除并关闭线程池
        mOkHttpClient.getConnectionPool().evictAll();                 //清除并关闭连接池
        try {
            mOkHttpClient.getCache().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected String sendPostRequest(HttpRequest httpRequest) throws AbstractImageException {
        mOkHttpClient.setProxy(config.getProxy());
        mOkHttpClient.setConnectTimeout(config.getConnectionTimeout(), TimeUnit.MILLISECONDS);
        mOkHttpClient.setReadTimeout(config.getSocketTimeout(), TimeUnit.MILLISECONDS);
        mOkHttpClient.setWriteTimeout(config.getSocketTimeout(), TimeUnit.MILLISECONDS);

        if (httpRequest.getContentType() == HttpContentType.APPLICATION_JSON) {
            Map<String, Object> params = httpRequest.getParams();
            String postBody = null;

            try {
                postBody = objectMapper.writeValueAsString(params);
            } catch (JsonProcessingException e) {
                //params map转成josn异常
                throw new UnknownException("request params map convert json error: " + postBody + ",\n" + e.getMessage());
            }
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), postBody);
            Builder requestBuilder = new Builder()
                    .url(httpRequest.getUrl())
                    .post(requestBody);
            Map<String, String> headers = httpRequest.getHeaders();
            for (String headerKey : headers.keySet()) {
                requestBuilder.addHeader(headerKey, headers.get(headerKey));
            }
            Response response = null;
            try {
                response = mOkHttpClient.newCall(requestBuilder.build()).execute();
            } catch (IOException e) {
                throw new ServerException(e);
            }

            if (!response.isSuccessful()) {
                String string = null;
                try {
                    string = response.body().string();
                } catch (IOException e) {
                    throw new ServerException("Unexpected response code and IOException while reading response string,\n" + response + ",\n" + e.getMessage());
                }
                return string;
            }

            String string = null;
            try {
                string = response.body().string();
            } catch (IOException e) {
                throw new ServerException("IOException while reading response string.\n" + e.getMessage());
            }
            try {
                objectMapper.readTree(string);
            } catch (IOException e) {
                throw new UnknownException("response is not json: " + string + ",\n" + e.getMessage());
            }
            return string;

        } else if (httpRequest.getContentType() == HttpContentType.MULTIPART_FORM_DATA) {
            HashMap<String, File> imageList = httpRequest.getImageList();
            Map<String, Object> params = httpRequest.getParams();
            MultipartBuilder multipartBuilder = new MultipartBuilder();

            //修复腾讯sdk byte[]报错的bug
            if (httpRequest.getBytesContentList() != null) {
                imageList = new HashMap<>();
            }

            try {
                setMultiPartEntity(multipartBuilder, params, imageList, httpRequest.getBytesContentList());
            } catch (FileNotFoundException e) {
                throw new ParamException(e.getMessage());
            }
            RequestBody requestBody = multipartBuilder.build();
            Builder requestBuilder = new Builder()
                    .url(httpRequest.getUrl())
                    .post(requestBody);
            Map<String, String> headers = httpRequest.getHeaders();
            for (String headerKey : headers.keySet()) {
                requestBuilder.addHeader(headerKey, headers.get(headerKey));
            }
            requestBuilder.addHeader("Connection", "close");//禁用长连接, 因为后台不支持
            Response response = null;
            try {
                response = mOkHttpClient.newCall(requestBuilder.build()).execute();
            } catch (IOException e) {
                throw new ServerException(e);
            }

            if (!response.isSuccessful()) {
                String string = null;
                try {
                    string = response.body().string();
                } catch (IOException e) {
                    throw new ServerException("Unexpected response code and IOException while reading response string,\n" + response + ",\n" + e.getMessage());
                }
                return string;
            }

            String string = null;
            try {
                string = response.body().string();
            } catch (IOException e) {
                throw new ServerException("IOException while reading response string.\n" + e.getMessage());
            }

            try {
                objectMapper.readTree(string);
            } catch (IOException e) {
                throw new UnknownException("response is not json: " + string + ",\n" + e.getMessage());
            }
            return string;
        } else {
            throw new ParamException("Unknown ContentType, httpRequest.getContentType():" + httpRequest.getContentType());
        }
    }

    private void setMultiPartEntity(MultipartBuilder multipartBuilder, Map<String, Object> params, Map<String, File> files, Map<String, byte[]> fileContents)
            throws FileNotFoundException {

        multipartBuilder.type(MultipartBuilder.FORM);
        for (String paramKey : params.keySet()) {
            multipartBuilder.addFormDataPart(paramKey, String.valueOf(params.get(paramKey)));
        }

        if (files.size() > 0) {
            for (String key : files.keySet()) {
                File file = files.get(key);
                if (file == null) {
                    throw new FileNotFoundException("File is null: " + key);
                }
                if (!file.exists()) {
                    throw new FileNotFoundException("File Not Exists: " + file.getAbsolutePath());
                }
                multipartBuilder.addPart(
                        Headers.of("Content-Disposition", String.format("form-data; name=\"%s\"; filename=\"%s\"", key, file.getName())),
                        RequestBody.create(MediaType.parse("image/jpg"), file)
                );
            }
        }

        for (String key : fileContents.keySet()) {
            byte[] content = fileContents.get(key);
            if (content != null && content.length > 0) {
                multipartBuilder.addPart(
                        //TODO file name not resolved
                        Headers.of("Content-Disposition", String.format("form-data; name=\"%s\"; filename=\"%s\"", key, "bytes" + System.currentTimeMillis())),
                        RequestBody.create(MediaType.parse("image/jpg"), content)
                );
            }
        }

    }
}
