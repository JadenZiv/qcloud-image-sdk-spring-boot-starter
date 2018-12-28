package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jadenziv
 * @date 2018/12/25 17:44
 */
@Data
public class FaceAddGroupIdsResult extends AbstractResult {

    /**
     * person ID
     */
    @JsonProperty("person_id")
    private String personId;

    /**
     * 成功新增组数
     */

    private Integer added;

    /**
     * 当前人所在组信息
     */
    @JsonProperty("group_ids")
    private List<String> groupIds;
}