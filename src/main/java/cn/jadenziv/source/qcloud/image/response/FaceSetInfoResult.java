package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: jadenziv
 * @date: 2018/12/25 18:31
 * @see {https://cloud.tencent.com/document/product/867/17583#.E8.AE.BE.E7.BD.AE.E4.BF.A1.E6.81.AF}  腾讯官方文档
 */
@Data
public class FaceSetInfoResult extends AbstractResult {

    /**
     * person ID
     */
    @JsonProperty("person_id")
    private String personId;
}