package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 图片标签 API
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/865/17592">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 10:53
 */
@Data
public class TagDetectResult {

    private Integer code;

    private String message;

    /**
     * 图像的分类标签列表
     */
    private List<Detail> tags;

    @Data
    public static class Detail {

        /**
         * 返回的图像标签名字
         */
        @JsonProperty("tag_name")
        private String tagName;

        /**
         * 图像标签的置信度，取值范围[0， 100]，数值越大置信度越高
         */
        @JsonProperty("tag_confidence")
        private Integer tagConfidence;
    }
}