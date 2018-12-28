package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 获取人脸列表
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E4.BA.BA.E8.84.B8.E5.88.97.E8.A1.A8">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/25 18:50
 */
@Data
public class FaceGetFaceIdsResult extends AbstractResult {

    /**
     * 相应 face 的 ID 列表
     */
    @JsonProperty("face_ids")
    private List<String> faceIds;

}