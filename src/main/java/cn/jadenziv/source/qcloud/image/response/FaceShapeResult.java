package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author jadenziv
 * @date 2018/12/25 18:18
 * @see {https://cloud.tencent.com/document/product/867/17585} 腾讯官方文档链接
 */
@Data
public class FaceShapeResult extends AbstractResult {

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

    @JsonProperty("face_shape")
    private Map<String, List<Point>> faceShape;

    @Data
    public class Point {
        /**
         * 坐标 x ，图片左上角为0
         */
        private Integer x;

        /**
         * 坐标 y ，图片左上角为0
         */
        private Integer y;
    }
}