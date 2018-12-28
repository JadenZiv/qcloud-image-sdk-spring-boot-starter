package cn.jadenziv.source.qcloud.image.response;

import lombok.Data;

/**
 * 获取人脸信息
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E4.BA.BA.E8.84.B8.E4.BF.A1.E6.81.AF">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/25 18:52
 */
@Data
public class FaceGetFaceInfoResult extends AbstractResult {

    /**
     * 人脸信息
     *
     * @see FaceDetectResult.Face
     */
    private FaceDetectResult.Face face;

}