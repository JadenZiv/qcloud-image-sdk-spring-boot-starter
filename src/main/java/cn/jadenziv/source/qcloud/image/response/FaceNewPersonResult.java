package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: jadenziv
 * @date: 2018/12/25 14:04
 */
@Data
public class FaceNewPersonResult extends AbstractResult {

    /**
     * 成功被加入的 group 数量
     */
    @JsonProperty("suc_group")
    private Integer sucGroup;

    /**
     * 成功加入的 face 数量
     */
    @JsonProperty("suc_face")
    private Integer sucFace;

    /**
     * 相应 person 的 ID
     */
    @JsonProperty("person_id")
    private String personId;

    /**
     * 创建所用图片生成的 face_id
     */
    @JsonProperty("face_id")
    private String faceId;

    /**
     * 加入成功的组 ID
     */
    @JsonProperty("group_ids")
    private List<String> groupIds;
}