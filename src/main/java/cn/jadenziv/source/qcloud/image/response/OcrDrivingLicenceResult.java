package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * OCR-行驶证驾驶证识别
 *
 * @author jadenziv
 * @date 2018/12/26 10:37
 * @see <a href="https://cloud.tencent.com/document/product/866/17599">官方文档</a>
 */
@Data
public class OcrDrivingLicenceResult extends AbstractResult {

    /**
     * 识别出的所有字段信息
     */
    private List<Item> items;

    @Data
    public class Item {

        private String item;

        @JsonProperty("itemstring")
        private String itemString;

        @JsonProperty("itemconf")
        private Float itemConf;

        private List<Itemcoord> itemcoord;
    }

    @Data
    public class Itemcoord {
        /**
         * item 框左上角 x
         */
        private Integer x;

        /**
         * item 框左上角 y
         */
        private Integer y;

        /**
         * item 框宽度
         */
        private Integer width;

        /**
         * item 框高度
         */
        private Integer height;
    }
}