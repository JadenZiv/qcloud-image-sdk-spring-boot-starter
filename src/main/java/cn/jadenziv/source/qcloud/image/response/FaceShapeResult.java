package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 五官定位
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/867/17585">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/25 18:18
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