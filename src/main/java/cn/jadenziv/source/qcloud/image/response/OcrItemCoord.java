package cn.jadenziv.source.qcloud.image.response;

import lombok.Data;

/**
 * ocr 的 基本对象
 *
 * @author JadenZiv
 * @date 2018/12/28 14:04
 */
@Data
public class OcrItemCoord {
    /**
     * item 框左上角 x
     */
    private Integer x;

    /**
     * item 框左上角 y
     */
    private Integer y;

    /**
     * item 框宽度
     */
    private Integer width;

    /**
     * item 框高度
     */
    private Integer height;
}
