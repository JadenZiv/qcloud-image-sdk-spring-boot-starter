package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * OCR-营业执照识别
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/866/17598">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 10:42
 */
@Data
public class OcrBizLicenseResult extends AbstractResult{


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

        /**
         * 下面四个字段腾讯文档没有详细标注,具体用途不明
         */
        private List coords;

        private List words;

        private List candword;

    }

}