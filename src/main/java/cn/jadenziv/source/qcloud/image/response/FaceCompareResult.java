package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 人脸对比
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/867/17584">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 09:06
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