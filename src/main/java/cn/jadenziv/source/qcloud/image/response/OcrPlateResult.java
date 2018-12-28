package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * OCR-车牌识别
 * <a href="https://cloud.tencent.com/document/product/866/17601">官方文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 10:02
 */
@Data
public class OcrPlateResult {

    /**
     * 识别出的所有字段信息
     */
    private List<Item> items;

    @Data
    public class Item {

        /**
         * 字段名称
         */
        private String item;

        /**
         * 字段内容
         */
        @JsonProperty("itemstring")
        private String itemString;

        /**
         * 字段识别结果置信度
         */
        @JsonProperty("itemconf")
        private Float itemConf;

        private Itemcoord itemcoord;
    }

    @Data
    public class Itemcoord {
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