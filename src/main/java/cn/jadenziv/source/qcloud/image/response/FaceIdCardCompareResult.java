package cn.jadenziv.source.qcloud.image.response;

import lombok.Data;

/**
 * 用户上传照片身份信息核验
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/868/17580">腾讯官方文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 11:01
 */
@Data
public class FaceIdCardCompareResult extends AbstractResult {

    /**
     * 用户上传的图像与身份证登记照的人脸相似度，取值范围[0,100]，推荐相似度大于75时可判断为同一人，可根据具体场景自行调整阈值
     */
    private Float similarity;

}