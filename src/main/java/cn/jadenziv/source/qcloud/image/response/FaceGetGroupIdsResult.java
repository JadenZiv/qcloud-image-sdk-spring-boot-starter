package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 获取组列表
 *
 * @author: jadenziv
 * @date: 2018/12/25 18:40
 * @see {https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E7.BB.84.E5.88.97.E8.A1.A8}  腾讯官方文档链接
 */
@Data
public class FaceGetGroupIdsResult extends AbstractResult {

    /**
     * 相应 appid 的 group_id 列表
     */
    @JsonProperty("group_ids")
    private List<String> groupIds;
}