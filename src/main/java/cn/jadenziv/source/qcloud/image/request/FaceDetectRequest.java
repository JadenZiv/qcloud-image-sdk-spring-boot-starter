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
 *
 * @author serenazhao 人脸检测请求
 */
public class FaceDetectRequest extends AbstractBaseRequest {
        //是否是url
        private boolean isUrl = true;
        // 检测模式，0为检测所有人脸，1为检测最大的人脸           
        private int mode = 0;
        
    	// url
	private String url = "";
        
	// 图片内容列表
        private File image ;
              
        /**
         * @param bucketName  bucket名字
         * @param url url
         * @param mode 检测模式，0为检测所有人脸，1为检测最大的人脸 
         */
        public FaceDetectRequest(String bucketName, String url, int mode) {
		super(bucketName);
		this.isUrl = true;
                this.mode = mode;
                this.url = url;
	}

        /**
         * 
         * @param bucketName bucket名字
         * @param name 文件名
         * @param image 图片内容
         * @param mode 检测模式，0为检测所有人脸，1为检测最大的人脸    
         */
        public FaceDetectRequest(String bucketName, String name, File image, int mode) {
		super(bucketName);
		this.isUrl = false;
                this.mode = mode;
                this.image = image;             
	}
        
        public boolean isUrl() {
            return isUrl;
        }
        
        public String getUrl() {
            return url;
        }
        
        public int getMode() {
            return mode;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public File getImage() {
            return image;
        }

        public void setImage(File image) {
            this.image = image;
        }

	@Override
	public void check_param() throws ParamException {
		super.check_param();
                if(isUrl){
                    CommonParamCheckUtils.AssertNotNull("url", url);
                }else{
                    CommonParamCheckUtils.AssertNotNull("image content", image);
                }

                if (mode != 0 && mode!= 1) {
                    throw new ParamException( "param mode error, please check!");
                }
	}
}
