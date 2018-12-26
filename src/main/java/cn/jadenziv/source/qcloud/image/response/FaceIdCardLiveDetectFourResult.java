package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 唇语活体检测视频身份信息核验
 *
 * @author: jadenziv
 * @date: 2018/12/26 11:13
 * @see <a href="https://cloud.tencent.com/document/product/868/17577">官方文档</a>
 */
@Data
public class FaceIdCardLiveDetectFourResult {

    /**
     * 活体检测错误码，非 0 值为出错
     */
    @JsonProperty("live_status")
    private Integer liveStatus;

    /**
     * 返回错误描述
     */
    @JsonProperty("live_msg")
    private String liveMsg;

    /**
     * 人脸对比检测错误码，非 0 值为出错
     */
    @JsonProperty("compare_status")
    private Integer compareStatus;

    /**
     * 人脸对比错误描述
     */
    @JsonProperty("compare_msg")
    private String compareMsg;

    /**
     * 相似度，取值范围 [0, 100]，推荐相似度大于70时可判断为同一人，可根据具体场景自行调整阈值（阈值 70 的误通过率为千分之一，阈值 80 的误通过率是万分之一）
     */
    private Integer sim;

    /**
     * 视频中的一张 sim 值最大的图像，base64 编码。
     */
    @JsonProperty("video_photo")
    private String videoPhoto;
}