package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 多脸检索
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/867/17590">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 09:21
 */
@Data
public class FaceMultiIdentifyResult extends AbstractResult {


    /**
     * 识别结果
     */
    private MultiIdentifyItem results;


    @Data
    public class MultiIdentifyItem {

        @JsonProperty("candidates")
        private List<Identifyitem> candidates;

        @JsonProperty("face_rect")
        private Facerectitem faceRect;

    }

    @Data
    public class Identifyitem {

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

    @Data
    public class Facerectitem {

        /**
         * 人脸位置左上角横坐标
         */
        private Integer x;

        /**
         * 人脸位置左上角纵坐标
         */
        private Integer y;

        /**
         * 人脸宽度
         */
        private Integer width;

        /**
         * 人脸高度
         */
        private Integer height;

    }


}