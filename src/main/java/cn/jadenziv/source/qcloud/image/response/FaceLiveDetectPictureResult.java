package cn.jadenziv.source.qcloud.image.response;

import lombok.Data;

/**
 * 人脸静态活体检测
 *
 * @author: jadenziv
 * @date: 2018/12/26 11:04
 * @see <a href="https://cloud.tencent.com/document/product/868/17575">官方文档</a>
 */
@Data
public class FaceLiveDetectPictureResult {

    /**
     * 活体打分，取值范围 [0,100]，分数一般落于[80, 100]区间内，0分也为常见值。推荐值大于 87 时可判断为活体。可根据具体场景自行调整阈值
     */
    private Integer score;
}