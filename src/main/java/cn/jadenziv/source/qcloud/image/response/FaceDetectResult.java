package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author jadenziv
 * @date 2018/12/25 17:54
 * @see {https://cloud.tencent.com/document/product/867/17588} 腾讯官方文档链接
 */
@Data
public class FaceDetectResult extends AbstractResult {

    /**
     * 请求图片的宽度
     */
    @JsonProperty("image_width")
    private Integer imageWidth;

    /**
     * 请求图片的高度
     */
    @JsonProperty("image_height")
    private Integer imageHeight;

    /**
     * 人脸信息
     */
    private Face face;

    @Data
    public static class Face {

        /**
         * 人脸标识
         */
        @JsonProperty("face_id")
        private String faceId;

        /**
         * 人脸框左上角 x
         */
        private Integer x;

        /**
         * 人脸框左上角 y
         */
        private Integer y;

        /**
         * 人脸框宽度
         */
        private Float width;

        /**
         * 人脸框高度
         */
        private Float height;

        /**
         * 性别 [0(female)~100(male)]
         */
        private Integer gender;

        /**
         * 年龄 [0~100]
         */
        private Integer age;

        /**
         * 微笑[0(normal)~50(smile)~100(laugh)]
         */
        private Integer expression;

        /**
         * 是否有眼镜 [true,false]
         */
        private Boolean glass;

        /**
         * 上下偏移[-30,30]
         */
        private Integer pitch;

        /**
         * 左右偏移[-30,30]
         */
        private Integer yaw;


        /**
         * 平面旋转[-180,180]
         */
        private Integer roll;

        /**
         * 魅力[0~100]
         */
        private Integer beauty;


    }
}