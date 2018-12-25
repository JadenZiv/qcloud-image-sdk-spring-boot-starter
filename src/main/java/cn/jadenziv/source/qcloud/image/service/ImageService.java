package cn.jadenziv.source.qcloud.image.service;

import cn.jadenziv.source.qcloud.image.Image;
import cn.jadenziv.source.qcloud.image.exception.AbstractImageException;
import cn.jadenziv.source.qcloud.image.request.*;
import cn.jadenziv.source.qcloud.image.response.AbstractResult;
import cn.jadenziv.source.qcloud.image.response.FaceIdentifyResult;
import cn.jadenziv.source.qcloud.image.response.FaceNewPersonResult;
import cn.jadenziv.source.qcloud.image.response.QcloudResult;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @Auther: jadenziv
 * @Date: 2018/12/25 13:37
 */
@Slf4j
public class ImageService {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private Image image;

    public Object ocrPlate(OcrPlateRequest request) throws AbstractImageException {
        String s = image.ocrPlate(request);
        return s;
    }

    public String ocrBankCard(OcrBankCardRequest request) throws AbstractImageException {
        return null;
    }

    public String ocrBizLicense(OcrBizLicenseRequest request) throws AbstractImageException {
        return null;
    }

    public String ocrDrivingLicence(OcrDrivingLicenceRequest request) throws AbstractImageException {
        return null;
    }


    public String generalOcr(GeneralOcrRequest request) throws AbstractImageException {
        return null;
    }


    public String pornDetect(PornDetectRequest request) throws AbstractImageException {
        return null;
    }


    public String tagDetect(TagDetectRequest request) throws AbstractImageException {
        return null;
    }


    public String idcardDetect(IdcardDetectRequest request) throws AbstractImageException {
        return null;
    }


    public String namecardDetect(NamecardDetectRequest request) throws AbstractImageException {
        return null;
    }


    public String faceDetect(FaceDetectRequest request) throws AbstractImageException {
        return null;
    }


    public String faceShape(FaceShapeRequest request) throws AbstractImageException {
        return null;
    }


    public QcloudResult<FaceNewPersonResult> faceNewPerson(FaceNewPersonRequest request) throws AbstractImageException {
        String json = image.faceNewPerson(request);
        return this.json2Result(json, QcloudResult.class, FaceNewPersonResult.class);
    }


    public String faceDelPerson(FaceDelPersonRequest request) throws AbstractImageException {
        return null;
    }


    public String faceAddFace(FaceAddFaceRequest request) throws AbstractImageException {
        return null;
    }


    public String faceDelFace(FaceDelFaceRequest request) throws AbstractImageException {
        return null;
    }


    public String faceSetInfo(FaceSetInfoRequest request) throws AbstractImageException {
        return null;
    }


    public String faceGetInfo(FaceGetInfoRequest request) throws AbstractImageException {
        return null;
    }


    public String faceGetGroupIds(FaceGetGroupIdsRequest request) throws AbstractImageException {
        return null;
    }


    public String faceAddGroupIds(FaceAddGroupIdsRequest request) throws AbstractImageException {
        return null;
    }


    public String faceDelGroupIds(FaceDelGroupIdsRequest request) throws AbstractImageException {
        return null;
    }


    public String faceGetPersonIds(FaceGetPersonIdsRequest request) throws AbstractImageException {
        return null;
    }


    public String faceGetFaceIds(FaceGetFaceIdsRequest request) throws AbstractImageException {
        return null;
    }


    public String faceGetFaceInfo(FaceGetFaceInfoRequest request) throws AbstractImageException {
        return null;
    }


    public QcloudResult<FaceIdentifyResult> faceIdentify(FaceIdentifyRequest request) throws AbstractImageException {
        String json = image.faceIdentify(request);
        return this.json2Result(json, QcloudResult.class, FaceIdentifyResult.class);
    }


    public String faceVerify(FaceVerifyRequest request) throws AbstractImageException {
        return null;
    }


    public String faceCompare(FaceCompareRequest request) throws AbstractImageException {
        return null;
    }


    public String faceMultiIdentify(FaceMultiIdentifyRequest request) throws AbstractImageException {
        return null;
    }


    public String faceIdCardCompare(FaceIdCardCompareRequest request) throws AbstractImageException {
        return null;
    }


    public String faceLiveGetFour(FaceLiveGetFourRequest request) throws AbstractImageException {
        return null;
    }


    public String faceIdCardLiveDetectFour(FaceIdCardLiveDetectFourRequest request) throws AbstractImageException {
        return null;
    }


    public String faceLiveDetectFour(FaceLiveDetectFourRequest request) throws AbstractImageException {
        return null;
    }


    public String faceLiveDetectPicture(FaceLiveDetectPictureRequest request) throws AbstractImageException {
        return null;
    }


    private static <T> T json2Result(String jsonString, Class<QcloudResult> clazz0, Class<? extends AbstractResult> clazz1) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(clazz0, clazz1);
        try {
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            log.info("【响应结果】{}", jsonString);
            throw new RuntimeException("json转对象出错\r\n" + e);
        }
    }
}