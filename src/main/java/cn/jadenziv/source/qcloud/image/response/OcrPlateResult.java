package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * OCR-车牌识别
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/866/17601">官方文档</a>
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
    public static class Item {

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

        private OcrItemCoord itemcoord;
    }

}