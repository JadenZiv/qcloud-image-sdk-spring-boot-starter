package cn.jadenziv.source.qcloud.image.service;

import cn.jadenziv.source.qcloud.image.Image;
import cn.jadenziv.source.qcloud.image.exception.AbstractImageException;
import cn.jadenziv.source.qcloud.image.request.*;
import cn.jadenziv.source.qcloud.image.response.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * 封装{@link cn.jadenziv.source.qcloud.image.ImageClient} 返回的json字符串
 * <a href="https://github.com/tencentyun/image-java-sdk-v2.0/blob/master/src/main/java/com/qcloud/image/demo/Demo.java">查看官方sdk demo</>
 *
 * @author jadenziv
 * @date 2018/12/25 13:37
 */
@Slf4j
public class ImageService {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private Image image;

    /**
     * OCR-车牌识别
     * <a href="https://cloud.tencent.com/document/product/866/17601">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     */
    public QcloudResult<OcrPlateResult> ocrPlate(OcrPlateRequest request) throws AbstractImageException {
        String json = image.ocrPlate(request);
        return json2QcloudResult(json, OcrPlateResult.class);
    }

    /**
     * OCR-银行卡识别
     * <a href="https://cloud.tencent.com/document/product/866/17602">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     */
    public QcloudResult<OcrBankCardResult> ocrBankCard(OcrBankCardRequest request) throws AbstractImageException {
        String json = image.ocrBankCard(request);
        return json2QcloudResult(json, OcrBankCardResult.class);
    }

    /**
     * OCR-营业执照识别
     *
     * @param request
     * @return {@link OcrBankCardResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/866/17598">查看文档</a>
     */
    public QcloudResult<OcrBizLicenseResult> ocrBizLicense(OcrBizLicenseRequest request) throws AbstractImageException {
        String json = image.ocrBizLicense(request);
        return json2QcloudResult(json, OcrBizLicenseResult.class);
    }

    /**
     * OCR-行驶证驾驶证识别
     *
     * @param request
     * @return {@link OcrDrivingLicenceResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/866/17599">查看文档</a>
     */
    public QcloudResult<OcrDrivingLicenceResult> ocrDrivingLicence(OcrDrivingLicenceRequest request) throws AbstractImageException {
        String json = image.ocrDrivingLicence(request);
        return json2QcloudResult(json, OcrDrivingLicenceResult.class);
    }


    /**
     * OCR-通用印刷体识别
     *
     * @param request
     * @return {@link GeneralOcrResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/866/17600">查看文档</a>
     */
    public QcloudResult<GeneralOcrResult> generalOcr(GeneralOcrRequest request) throws AbstractImageException {
        String json = image.generalOcr(request);
        return json2QcloudResult(json, GeneralOcrResult.class);
    }


    /**
     * 黄图识别
     *
     * @param request
     * @return {@link OcrBizLicenseResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/864/17609">查看文档</a>
     */
    public List<OcrBizLicenseResult> pornDetect(PornDetectRequest request) throws AbstractImageException {
        String json = image.pornDetect(request);
        try {
            return objectMapper.readValue(json, new TypeReference<List<OcrBizLicenseResult>>() {
            });
        } catch (IOException e) {
            log.info("【响应结果】{}", json);
            throw new RuntimeException("json转对象出错\r\n" + e);
        }
    }


    /**
     * 图片标签 API
     *
     * @param request
     * @return {@link TagDetectResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/865/17592">查看文档</a>
     */
    public TagDetectResult tagDetect(TagDetectRequest request) throws AbstractImageException {
        String json = image.tagDetect(request);
        try {
            return objectMapper.readValue(json, TagDetectResult.class);
        } catch (IOException e) {
            log.info("【响应结果】{}", json);
            throw new RuntimeException("json转对象出错\r\n" + e);
        }
    }


    /**
     * OCR-身份证识别
     *
     * @param request
     * @return {@link IdcardDetectResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/866/17597">查看文档</a>
     */
    public List<IdcardDetectResult> idcardDetect(IdcardDetectRequest request) throws AbstractImageException {
        String json = image.idcardDetect(request);
        try {
            return objectMapper.readValue(json, new TypeReference<List<IdcardDetectResult>>() {
            });
        } catch (IOException e) {
            log.info("【响应结果】{}", json);
            throw new RuntimeException("json转对象出错\r\n" + e);
        }
    }


    /**
     * OCR-名片识别（V2）
     *
     * @param request
     * @return {@link NamecardDetectResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/866/17595">查看文档</>
     */
    public List<NamecardDetectResult> namecardDetect(NamecardDetectRequest request) throws AbstractImageException {
        String json = image.namecardDetect(request);
        try {
            return objectMapper.readValue(json, new TypeReference<List<NamecardDetectResult>>() {
            });
        } catch (IOException e) {
            log.info("【响应结果】{}", json);
            throw new RuntimeException("json转对象出错\r\n" + e);
        }
    }


    /**
     * 人脸检测
     * <a href="https://cloud.tencent.com/document/product/867/17588">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     */
    public QcloudResult<FaceDetectResult> faceDetect(FaceDetectRequest request) throws AbstractImageException {
        String json = image.faceDetect(request);
        return json2QcloudResult(json, FaceDetectResult.class);
    }


    /**
     * 五官定位
     * <a href="https://cloud.tencent.com/document/product/867/17585">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     */
    public QcloudResult<FaceShapeResult> faceShape(FaceShapeRequest request) throws AbstractImageException {
        String json = image.faceShape(request);
        return json2QcloudResult(json, FaceShapeResult.class);
    }


    public QcloudResult<FaceNewPersonResult> faceNewPerson(FaceNewPersonRequest request) throws AbstractImageException {
        String json = image.faceNewPerson(request);
        return json2QcloudResult(json, FaceNewPersonResult.class);
    }


    public QcloudResult<FaceDelPersonResult> faceDelPerson(FaceDelPersonRequest request) throws AbstractImageException {
        String json = image.faceDelPerson(request);
        return json2QcloudResult(json, FaceDelPersonResult.class);
    }


    public QcloudResult<FaceAddFaceResult> faceAddFace(FaceAddFaceRequest request) throws AbstractImageException {
        String json = image.faceAddFace(request);
        return json2QcloudResult(json, FaceAddFaceResult.class);
    }

    /**
     * 删除人脸
     *
     * @param request
     * @return {@link FaceDelFaceResult}
     * @throws AbstractImageException
     * @see {https://cloud.tencent.com/document/product/867/17583#.E5.88.A0.E9.99.A4.E4.BA.BA.E8.84.B8}  查看文档
     */
    public QcloudResult<FaceDelFaceResult> faceDelFace(FaceDelFaceRequest request) throws AbstractImageException {
        String json = image.faceDelFace(request);
        return json2QcloudResult(json, FaceDelFaceResult.class);
    }


    /**
     * 个体设置信息接口
     *
     * @param request
     * @return {@link FaceSetInfoResult}
     * @throws AbstractImageException
     * @see {https://cloud.tencent.com/document/product/867/17583#.E8.AE.BE.E7.BD.AE.E4.BF.A1.E6.81.AF}  查看文档
     */
    public QcloudResult<FaceSetInfoResult> faceSetInfo(FaceSetInfoRequest request) throws AbstractImageException {
        String json = image.faceSetInfo(request);
        return json2QcloudResult(json, FaceSetInfoResult.class);
    }


    /**
     * 个体获取信息
     *
     * @param request
     * @return {@link FaceGetInfoResult}
     * @throws AbstractImageException
     * @see {https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E4.BF.A1.E6.81.AF} 查看文档
     */
    public QcloudResult<FaceGetInfoResult> faceGetInfo(FaceGetInfoRequest request) throws AbstractImageException {
        String json = image.faceGetInfo(request);
        return json2QcloudResult(json, FaceGetInfoResult.class);
    }


    /**
     * 获取组列表
     *
     * @param request
     * @return {@link FaceGetGroupIdsResult}
     * @throws AbstractImageException
     * @see {https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E7.BB.84.E5.88.97.E8.A1.A8}  查看文档
     */
    public QcloudResult<FaceGetGroupIdsResult> faceGetGroupIds(FaceGetGroupIdsRequest request) throws AbstractImageException {
        String json = image.faceGetGroupIds(request);
        return json2QcloudResult(json, FaceGetGroupIdsResult.class);
    }


    public QcloudResult<FaceAddGroupIdsResult> faceAddGroupIds(FaceAddGroupIdsRequest request) throws AbstractImageException {
        String json = image.faceAddGroupIds(request);
        return json2QcloudResult(json, FaceAddGroupIdsResult.class);
    }


    public QcloudResult<FaceDelGroupIdsResult> faceDelGroupIds(FaceDelGroupIdsRequest request) throws AbstractImageException {
        String json = image.faceDelGroupIds(request);
        return json2QcloudResult(json, FaceDelGroupIdsResult.class);
    }


    /**
     * 获取人列表
     *
     * @param request
     * @return {@link FaceGetPersonIdsResult}
     * @throws AbstractImageException
     * @see {https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E4.BA.BA.E5.88.97.E8.A1.A8}  查看文档
     */
    public QcloudResult<FaceGetPersonIdsResult> faceGetPersonIds(FaceGetPersonIdsRequest request) throws AbstractImageException {
        String json = image.faceGetPersonIds(request);
        return json2QcloudResult(json, FaceGetPersonIdsResult.class);
    }


    /**
     * 获取人脸列表
     *
     * @param request
     * @return {@link FaceGetFaceIdsResult}
     * @throws AbstractImageException
     * @see {https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E4.BA.BA.E8.84.B8.E5.88.97.E8.A1.A8} 查看文档
     */
    public QcloudResult<FaceGetFaceIdsResult> faceGetFaceIds(FaceGetFaceIdsRequest request) throws AbstractImageException {
        String json = image.faceGetFaceIds(request);
        return json2QcloudResult(json, FaceGetFaceIdsResult.class);
    }


    /**
     * 获取人脸信息
     *
     * @param request
     * @return {@link FaceGetFaceInfoResult}
     * @throws AbstractImageException
     * @see {https://cloud.tencent.com/document/product/867/17583#.E8.8E.B7.E5.8F.96.E4.BA.BA.E8.84.B8.E4.BF.A1.E6.81.AF} 查看文档
     */
    public QcloudResult<FaceGetFaceInfoResult> faceGetFaceInfo(FaceGetFaceInfoRequest request) throws AbstractImageException {
        String json = image.faceGetFaceInfo(request);
        return json2QcloudResult(json, FaceGetFaceInfoResult.class);
    }


    public QcloudResult<FaceIdentifyResult> faceIdentify(FaceIdentifyRequest request) throws AbstractImageException {
        String json = image.faceIdentify(request);
        return json2QcloudResult(json, FaceIdentifyResult.class);
    }


    /**
     * 人脸验证
     *
     * @param request
     * @return {@link FaceVerifyResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/867/17589">查看文档</a>
     */
    public QcloudResult<FaceVerifyResult> faceVerify(FaceVerifyRequest request) throws AbstractImageException {
        String json = image.faceVerify(request);
        return json2QcloudResult(json, FaceVerifyResult.class);
    }


    /**
     * 人脸对比
     *
     * @param request
     * @return {@link FaceCompareResult}
     * @throws AbstractImageException
     * @see <a href="https://cloud.tencent.com/document/product/867/17584">查看文档</a>
     */
    public QcloudResult<FaceCompareResult> faceCompare(FaceCompareRequest request) throws AbstractImageException {
        String json = image.faceCompare(request);
        return json2QcloudResult(json, FaceVerifyResult.class);
    }


    /**
     * 多脸检索
     * <a href="https://cloud.tencent.com/document/product/867/17590">查看文档</a>
     *
     * @param request
     * @return 
     * @throws AbstractImageException
     */
    public QcloudResult<FaceMultiIdentifyResult> faceMultiIdentify(FaceMultiIdentifyRequest request) throws AbstractImageException {
        String json = image.faceMultiIdentify(request);
        return json2QcloudResult(json, FaceMultiIdentifyResult.class);
    }


    /**
     * 用户上传照片身份信息核验
     * <a href="https://cloud.tencent.com/document/product/868/17580">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     */
    public QcloudResult<FaceIdCardCompareResult> faceIdCardCompare(FaceIdCardCompareRequest request) throws AbstractImageException {
        String json = image.faceIdCardCompare(request);
        return json2QcloudResult(json, FaceIdCardCompareResult.class);
    }


    /**
     * 活体检测—获取唇语验证码
     * <a href="https://cloud.tencent.com/document/product/868/17579">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     */
    public QcloudResult<FaceLiveGetFourResult> faceLiveGetFour(FaceLiveGetFourRequest request) throws AbstractImageException {
        String json = image.faceLiveGetFour(request);
        return json2QcloudResult(json, FaceLiveGetFourResult.class);
    }

    /**
     * 唇语活体检测视频身份信息核验
     * <a href="https://cloud.tencent.com/document/product/868/17577">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     */
    public QcloudResult<FaceIdCardLiveDetectFourResult> faceIdCardLiveDetectFour(FaceIdCardLiveDetectFourRequest request) throws AbstractImageException {
        String json = image.faceIdCardLiveDetectFour(request);
        return json2QcloudResult(json, FaceIdCardLiveDetectFourResult.class);
    }


    /**
     * 活体检测视频与用户照片的对比
     *
     * <a href="https://cloud.tencent.com/document/product/868/17578">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     * @see
     */
    public QcloudResult<FaceLiveDetectFourResult> faceLiveDetectFour(FaceLiveDetectFourRequest request) throws AbstractImageException {
        String json = image.faceLiveDetectFour(request);
        return json2QcloudResult(json, FaceLiveDetectFourResult.class);
    }


    /**
     * 人脸静态活体检测
     * <a href="https://cloud.tencent.com/document/product/868/17575">查看文档</a>
     *
     * @param request
     * @return
     * @throws AbstractImageException
     */
    public QcloudResult<FaceLiveDetectPictureResult> faceLiveDetectPicture(FaceLiveDetectPictureRequest request) throws AbstractImageException {
        String json = image.faceLiveDetectPicture(request);
        return json2QcloudResult(json, FaceLiveDetectPictureResult.class);
    }


    /**
     * json转QcloudResult<T>
     *
     * @param jsonString
     * @param classes
     * @param <T>
     * @return
     */
    private static <T> T json2QcloudResult(String jsonString, Class<?>... classes) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(QcloudResult.class, classes);
        try {
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            log.info("【响应结果】{}", jsonString);
            throw new RuntimeException("json转对象出错\r\n" + e);
        }
    }
}