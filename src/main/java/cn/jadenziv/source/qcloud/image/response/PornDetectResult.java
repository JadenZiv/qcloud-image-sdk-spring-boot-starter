package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 黄图识别结果
 *
 * @author: jadenziv
 * @date: 2018/12/26 10:42
 */
@Data
public class PornDetectResult {

    @JsonProperty("result_list")
    private List<ResultList> resultList;

    public class ResultList {

        private Integer code;

        private String message;

        private String url;


    }
}