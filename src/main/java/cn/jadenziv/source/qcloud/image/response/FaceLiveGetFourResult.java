package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 活体检测—获取唇语验证码
 * <a href="https://cloud.tencent.com/document/product/868/17579">官方文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 11:07
 */
@Data
public class FaceLiveGetFourResult {

    /**
     * 唇语验证字符串
     */
    @JsonProperty("validate_data")
    private String validateData;
}