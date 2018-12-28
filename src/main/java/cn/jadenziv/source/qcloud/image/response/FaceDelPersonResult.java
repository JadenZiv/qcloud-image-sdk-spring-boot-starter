package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author jadenziv
 * @date 2018/12/25 17:38
 */
@Data
public class FaceDelPersonResult extends AbstractResult {

    /**
     * 成功删除的 person_id
     */
    @JsonProperty("person_id")
    private String personId;

    /**
     * 成功删除的 person 数量
     */
    private Integer deleted;
}