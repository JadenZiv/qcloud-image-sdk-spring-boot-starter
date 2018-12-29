package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * OCR-通用印刷体识别
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/866/17600">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 10:38
 */
@Data
public class GeneralOcrResult extends AbstractResult {

    /**
     * 识别出的所有字段信息
     */
    private List<Item> items;


    //下面四个字段具体功能不明
    @JsonProperty("class")
    private List clazz;

    @JsonProperty("recognize_warn_msg")
    private List recognizeWarnMsg;

    @JsonProperty("recognize_warn_code")
    private List recognizeWarnCode;

    private Float angle;


    @Data
    public static class Item {

        @JsonProperty("itemstring")
        private String itemString;

        private OcrItemCoord itemcoord;

        private List<Word> words;
    }

    @Data
    public static class Word {

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