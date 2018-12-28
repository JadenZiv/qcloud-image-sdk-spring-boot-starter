package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 个体设置信息接口
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/867/17583#.E8.AE.BE.E7.BD.AE.E4.BF.A1.E6.81.AF">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/25 18:31
 */
@Data
public class FaceSetInfoResult extends AbstractResult {

    /**
     * person ID
     */
    @JsonProperty("person_id")
    private String personId;
}