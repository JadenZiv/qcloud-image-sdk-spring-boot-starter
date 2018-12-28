package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author jadenziv
 * @date 2018/12/25 18:27
 * @see {https://cloud.tencent.com/document/product/867/17583#.E5.88.A0.E9.99.A4.E4.BA.BA.E8.84.B8}  腾讯官方文档
 */
@Data
public class FaceDelFaceResult extends AbstractResult {

    private Integer deleted;


    /**
     * 成功删除的 face_id 列表
     */
    @JsonProperty("face_ids")
    private List<String> faceIds;


}