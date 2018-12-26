package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @
 * @author: jadenziv
 * @date: 2018/12/26 09:06
 * @see <a href="https://cloud.tencent.com/document/product/867/17584">腾讯官方文档</a>
 */
@Data
public class FaceCompareResult extends AbstractResult {

    /**
     * 两个 face 的相似度
     */
    private Float similarity;

    /**
     * 标志失败图片，1 为第一张，2 为第二张（失败时返回）。
     */
    @JsonProperty("fail_flag")
    private Integer failFlag;

}