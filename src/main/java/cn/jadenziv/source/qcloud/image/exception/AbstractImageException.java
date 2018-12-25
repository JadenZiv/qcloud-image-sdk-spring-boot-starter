package cn.jadenziv.source.qcloud.image.exception;

import cn.jadenziv.source.qcloud.image.http.ResponseBodyKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装cos异常
 *
 * @author chengwu
 */
public abstract class AbstractImageException extends Exception {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final long serialVersionUID = 7547532865194837136L;

    private ImageExceptionType type;

    public AbstractImageException(String message, Throwable cause, ImageExceptionType type) {
        super(message, cause);
        this.type = type;
    }

    public AbstractImageException(ImageExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public ImageExceptionType getType() {
        return type;
    }

    @Override
    public String toString() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(ResponseBodyKey.CODE, type.getErrorCode());
        resultMap.put(ResponseBodyKey.MESSAGE, getMessage());
        try {
            return objectMapper.writeValueAsString(resultMap);
        } catch (JsonProcessingException e) {
            //map 转json错误
            throw new RuntimeException("map error: " + resultMap + ",\n" + e.getMessage());
        }
    }

}
