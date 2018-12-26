package cn.jadenziv.source.qcloud.image.response;

import lombok.Data;

/**
 * 返回对象
 *
 * @author: jadenziv
 * @date: 2018/11/27 16:42
 */
@Data
public class QcloudResult<T> {

    private Integer code;

    private String message;

    private T data;

}