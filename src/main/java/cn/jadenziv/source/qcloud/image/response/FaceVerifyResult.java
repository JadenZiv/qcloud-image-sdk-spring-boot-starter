package cn.jadenziv.source.qcloud.image.response;

import lombok.Data;

/**
 * 人脸验证
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/867/17589">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/25 18:58
 */
@Data
public class FaceVerifyResult extends AbstractResult {

    /**
     * 两个人的相似度
     */
    private Float confidence;

    /**
     * 两个输入是否为同一人的判断
     */
    private Boolean ismatch;
}