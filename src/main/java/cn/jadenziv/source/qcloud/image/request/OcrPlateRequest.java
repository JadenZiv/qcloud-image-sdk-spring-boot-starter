/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.jadenziv.source.qcloud.image.request;

import cn.jadenziv.source.qcloud.image.common_utils.CommonParamCheckUtils;
import cn.jadenziv.source.qcloud.image.exception.ParamException;

import java.io.File;

/**
 * OCR-车牌号识别
 */
public class OcrPlateRequest extends AbstractBaseRequest {

    private boolean isUrl;
    private String url = "";
    private File image;

    public OcrPlateRequest(String bucketName, String url) {
        super(bucketName);
        this.isUrl = true;
        this.url = url;
    }

    public OcrPlateRequest(String bucketName, File image) {
        super(bucketName);
        this.isUrl = false;
        this.image = image;
    }

    @Override
    public void check_param() throws ParamException {
        super.check_param();
        if (isUrl) {
            CommonParamCheckUtils.AssertNotNull("url", url);
        } else {
            CommonParamCheckUtils.AssertNotNull("image content", image);
        }
    }

    public boolean isUrl() {
        return isUrl;
    }

    public String getUrl() {
        return url;
    }

    public File getImage() {
        return image;
    }

}
