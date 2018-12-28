package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * OCR-名片识别（V2）
 *
 * @author jadenziv
 * @date 2018/12/26 11:29
 * @see <a href="https://cloud.tencent.com/document/product/866/17595">官方文档</>
 */
@Data
public class NamecardDetectResult {

    private Integer code;

    private String message;

    @JsonProperty("filename")
    private String fileName;

    private List<Detail> data;

    @Data
    public class Detail {

        /**
         * 字段字符串
         */
        private String item;

        /**
         * 字段识别出来的信息
         */
        private String value;

        /**
         * 字段识别出来的信息的置信度，取值范围[0,1]
         */
        private Double confidence;
    }

}