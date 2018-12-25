package cn.jadenziv.source.qcloud.image.response;

import cn.jadenziv.source.qcloud.image.request.FaceIdentifyRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @see cn.jadenziv.source.qcloud.image.Image#faceIdentify(FaceIdentifyRequest)
 * @Auther: jadenziv
 * @Date: 2018/12/25 15:25
 */
@Data
public class FaceIdentifyResult extends AbstractResult{

    @JsonProperty("time_ms")
    private Long timems;

    @JsonProperty("group_size")
    private Integer groupSize;

    private List<Candidates> candidates;

    @Data
    public static class Candidates {

        /**
         * 候选者 person_id
         */
        @JsonProperty("person_id")
        private String personId;

        /**
         * 候选者 face_id
         */
        @JsonProperty("face_id")
        private String faceId;

        /**
         * 候选者的置信度
         */
        private Float confidence;

        /**
         * 人脸备注信息
         */
        private String tag;
    }
}