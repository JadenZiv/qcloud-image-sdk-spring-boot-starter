package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author jadenziv
 * @date 2018/12/25 17:41
 */
@Data
public class FaceAddFaceResult extends AbstractResult{

    /**
     * 成功加入的 face 数量
     */
    private Integer added;

    /**
     * 增加的人脸 ID 列表
     */
    @JsonProperty("face_ids")
    private List<String> faceIds;

    /**
     * 每张图片增加人脸的返回码
     */
    @JsonProperty("ret_codes")
    private List<Integer> retCodes;
}