package cn.jadenziv.source.qcloud.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * OCR-身份证识别
 *
 * @author: jadenziv
 * @date: 2018/12/26 11:36
 * @see <a href="https://cloud.tencent.com/document/product/866/17597">官方文档</a>
 */
@Data
public class IdcardDetectResult {

    private Integer code;

    private String message;

    /**
     * 当前图片的 url
     */
    private String url;

    /**
     * 具体查询数据，内容见下表
     */
    private List<Detail> data;


    @Data
    public class Detail {

        /**
         * 姓名
         */
        private String name;

        /**
         * 性别
         */
        private String sex;

        /**
         * 民族
         */
        private String nation;

        /**
         * 出生日期
         */
        private String birth;

        /**
         * 地址
         */
        private String address;

        /**
         * 身份证号
         */
        private String id;

        /**
         * 证件姓名置信度，取值范围[0,100]
         */
        @JsonProperty("name_confidence_all")
        private List<Integer> nameConfidenceAll;

        /**
         * 性别置信度，取值范围[0,100]
         */
        @JsonProperty("sex_confidence_all")
        private List<Integer> sexConfidenceAll;

        /**
         * 民族置信度，取值范围[0,100]
         */
        @JsonProperty("nation_confidence_all")
        private List<Integer> nationConfidenceAll;

        /**
         * 出生日期置信度，取值范围[0,100]
         */
        @JsonProperty("birth_confidence_all")
        private List<Integer> birthConfidenceAll;


        /**
         * 地址置信度，取值范围[0,100]
         */
        @JsonProperty("address_confidence_all")
        private List<Integer> addressConfidenceAll;

        /**
         * 身份证号置信度,，取值范围[0,100]
         */
        @JsonProperty("id_confidence_all")
        private List<Integer> idConfidenceAll;


    }

}