package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author jadenziv
 * @date 2018/12/25 17:48
 */
@Data
public class FaceDelGroupIdsResult extends AbstractResult{

    /**
     * person ID
     */
    @JsonProperty("person_id")
    private String personId;

    /**
     * 成功删除组数
     */
    private Integer deleted;

    /**
     * 当前人所在组信息
     */
    @JsonProperty("group_ids")
    private List<String> groupIds;
}