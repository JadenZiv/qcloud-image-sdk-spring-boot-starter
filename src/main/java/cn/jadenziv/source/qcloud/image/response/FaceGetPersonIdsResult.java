package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 获取人列表
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E4.BA.BA.E5.88.97.E8.A1.A8">查看文档</a>
 *
 * @author jadenziv
 * @date 2018/12/25 18:47
 */
@Data
public class FaceGetPersonIdsResult extends AbstractResult {

    /**
     * 相应 person 的 ID 列表
     */
    @JsonProperty("person_ids")
    private String personIds;

}