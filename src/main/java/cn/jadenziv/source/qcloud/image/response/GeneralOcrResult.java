package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * OCR-通用印刷体识别
 *
 * @author: jadenziv
 * @date: 2018/12/26 10:38
 * @see <a href="https://cloud.tencent.com/document/product/866/17600#.E7.A4.BA.E4.BE.8B">官方文档</a>
 */
@Data
public class GeneralOcrResult extends AbstractResult {

    /**
     * 识别出的所有字段信息
     */
    private List<Item> items;

    @Data
    public class Item {

        @JsonProperty("itemstring")
        private String itemString;

        private Itemcoord itemcoord;

        private List<Word> words;
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

    @Data
    public class Word {

        /**
         * 单字的内容
         */
        private String character;

        /**
         * 这个字的置信度，取值范围 [0,100]
         */
        private Float confidence;
    }
}