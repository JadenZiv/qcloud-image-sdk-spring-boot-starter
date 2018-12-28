package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 活体检测视频与用户照片的对比
 * <a target="_blank"  href="https://cloud.tencent.com/document/product/868/17578">官方文档</a>
 *
 * @author jadenziv
 * @date 2018/12/26 11:10
 */
@Data
public class FaceLiveDetectFourResult {

    /**
     * 返回活体检测错误码，非0值为出错。
     */
    @JsonProperty("live_status")
    private Integer liveStatus;

    /**
     * 返回错误描述
     */
    @JsonProperty("live_msg")
    private String liveMsg;

    /**
     * 返回人脸对比检测错误码，非0值为出错( compare_flag 是 True 的时候才返回)。
     */
    @JsonProperty("compare_status")
    private Integer compareStatus;

    /**
     * 返回错误描述( compare_flag 是 True 的时候才返回)。
     */
    @JsonProperty("compare_msg")
    private String compareMsg;

    /**
     * 相似度，取值范围 [0, 100]，推荐相似度大于70时可判断为同一人，
     * 可根据具体场景自行调整阈值（阈值70的误通过率为千分之一，阈值80的误通过率是万分之一）
     * ( compare_flag 是 True 并且识别成功的时候才返回)
     */
    private Integer sim;

    /**
     * 返回相似度最高的 video 中的一张图像( compare_flag 是 True 并且识别成功的时候才返回， base64编码)
     */
    private String photo;

}