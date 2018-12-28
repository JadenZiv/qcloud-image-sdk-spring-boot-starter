package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 个体获取信息返回参数
 *
 * @author jadenziv
 * @date 2018/12/25 18:34
 * @see {https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E4.BF.A1.E6.81.AF} 腾讯官方文档
 */
@Data
public class FaceGetInfoResult extends AbstractResult {

    /**
     * person ID
     */
    @JsonProperty("person_id")
    private String personId;

    /**
     * 相应 person 的 name
     */
    @JsonProperty("person_name")
    private String personName;

    /**
     * 包含的人脸列表
     */
    @JsonProperty("face_ids")
    private List<String> faceIds;

    /**
     * 包含此个体的组 ID
     */
    @JsonProperty("group_ids")
    private String groupIds;

    /**
     * 为此个体设置的备注信息
     */
    private String tag;

}