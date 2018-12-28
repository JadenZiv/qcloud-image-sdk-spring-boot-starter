package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 智能鉴黄 API
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/864/17609">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 10:34
 */
@Data
public class PornDetectResult {

    private Integer code;

    private String message;

    /**
     * 当前图片的 url
     */
    private String url;

    /**
     * 具体查询数据，具体见下表
     */
    private Detail data;

    @Data
    public static class Detail {

        /**
         * 供参考的识别结果：0为正常，1为黄图，2为疑似图片
         */
        private Integer result;

        /**
         * 识别为黄图的置信度，分值 0-100；是 normal_score、hot_score、porn_score 的综合评分
         */
        private Double confidence;

        /**
         * 图片为正常图片的评分
         */
        @JsonProperty("normal_score")
        private Double normalScore;

        /**
         * 图片为性感图片的评分
         */
        @JsonProperty("hotScore")
        private Double hot_score;

        /**
         * 图片为色情图片的评分
         */
        @JsonProperty("porn_score")
        private Double pornScore;

        /**
         * 封禁状态，0表示正常，1表示图片已被封禁（只有存储在腾讯云的图片才会被封禁）
         */
        @JsonProperty("forbid_status")
        private Integer forbidStatus;
    }
}