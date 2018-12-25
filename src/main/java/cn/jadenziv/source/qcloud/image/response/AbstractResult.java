package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: jadenziv
 * @Date: 2018/12/25 14:01
 */
@Getter
@Setter
public abstract class AbstractResult {

    /**
     * sessionId
     */
    @JsonProperty("session_id")
    protected String sessionId;
}