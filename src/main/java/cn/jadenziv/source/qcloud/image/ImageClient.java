package cn.jadenziv.source.qcloud.image;

import cn.jadenziv.source.qcloud.image.exception.AbstractImageException;
import cn.jadenziv.source.qcloud.image.http.AbstractImageHttpClient;
import cn.jadenziv.source.qcloud.image.http.DefaultImageHttpClient;
import cn.jadenziv.source.qcloud.image.op.DetectionOp;
import cn.jadenziv.source.qcloud.image.request.*;
import cn.jadenziv.source.qcloud.image.sign.Credentials;

import java.net.Proxy;

/**
 * @author chengwu 封装Image JAVA SDK暴露给用户的接口函数
 */
public class ImageClient implements Image {

    private ClientConfig config;
    private Credentials cred;
    private AbstractImageHttpClient client;

    private DetectionOp detectionOp;

    /** 老域名 */
    public static final String OLD_DOMAIN_service_image_myqcloud_com = "service.image.myqcloud.com";
    /** 新域名 */
    public static final String NEW_DOMAIN_recognition_image_myqcloud_com = "recognition.image.myqcloud.com";
    
    /**
     * @param domain {@link #OLD_DOMAIN_service_image_myqcloud_com} or {@link #NEW_DOMAIN_recognition_image_myqcloud_com}
     */
    public ImageClient(String appId, String secretId, String secretKey, String domain) {
        this(new Credentials(appId, secretId, secretKey));
        ClientConfig.QCLOUD_IMAGE_DOMAIN = domain;
    }

    public ImageClient(Credentials cred) {
        this(new ClientConfig(), cred);
    }

    public void setConfig(ClientConfig config) {
        this.config = config;
        this.detectionOp.setConfig(config);
        this.client.shutdown();
        this.client = new DefaultImageHttpClient(config);
        this.detectionOp.setHttpClient(this.client);
    }

    public void setCred(Credentials cred) {
        this.cred = cred;
        this.detectionOp.setCred(cred);
    }

    public void setProxy(Proxy proxy) {
        this.config.setProxy(proxy);
    }

    public ImageClient(ClientConfig config, Credentials cred) {
        this.config = config;
        this.cred = cred;
        this.client = new DefaultImageHttpClient(config);
        detectionOp = new DetectionOp(this.config, this.cred, this.client);
    }


    @Override
    public String pornDetect(PornDetectRequest request) throws AbstractImageException {
            return detectionOp.pornDetect(request);
    }
    
    @Override
    public String tagDetect(TagDetectRequest request) throws AbstractImageException {
            return detectionOp.tagDetect(request);
    }
    
    @Override
    public String idcardDetect(IdcardDetectRequest request) throws AbstractImageException {
            return detectionOp.idcardDetect(request);
    }
    
    @Override
    public String namecardDetect(NamecardDetectRequest request) throws AbstractImageException {
            return detectionOp.namecardDetect(request);
    }

    @Override
    public String ocrBizLicense(OcrBizLicenseRequest request) throws AbstractImageException {
            return detectionOp.ocrBizLicense(request);
    }

    @Override
    public String ocrBankCard(OcrBankCardRequest request) throws AbstractImageException {
            return detectionOp.ocrBankCard(request);
    }
    @Override
    public String ocrPlate(OcrPlateRequest request) throws AbstractImageException {
            return detectionOp.ocrPlate(request);
    }

    @Override
    public String ocrDrivingLicence(OcrDrivingLicenceRequest request) throws AbstractImageException {
            return detectionOp.ocrDrivingLicence(request);
    }

    @Override
    public String generalOcr(GeneralOcrRequest request) throws AbstractImageException {
            return detectionOp.generalOcr(request);
    }
    
    @Override
    public String faceDetect(FaceDetectRequest request) throws AbstractImageException {
            return detectionOp.faceDetect(request);
    }
    
    @Override
    public String faceShape(FaceShapeRequest request) throws AbstractImageException {
            return detectionOp.faceShape(request);
    }
    
    @Override
    public String faceNewPerson(FaceNewPersonRequest request) throws AbstractImageException {
            return detectionOp.faceNewPerson(request);
    }
    
    @Override
    public String faceDelPerson(FaceDelPersonRequest request) throws AbstractImageException {
            return detectionOp.faceDelPerson(request);
    }
    
    @Override
    public String faceAddFace(FaceAddFaceRequest request) throws AbstractImageException {
            return detectionOp.faceAddFace(request);
    }
    
    @Override
    public String faceDelFace(FaceDelFaceRequest request) throws AbstractImageException {
            return detectionOp.faceDelFace(request);
    }
    
    @Override
    public String faceSetInfo(FaceSetInfoRequest request) throws AbstractImageException {
            return detectionOp.faceSetInfo(request);
    }
    
    @Override
    public String faceGetInfo(FaceGetInfoRequest request) throws AbstractImageException {
            return detectionOp.faceGetInfo(request);
    }
    
    @Override
    public String faceGetGroupIds(FaceGetGroupIdsRequest request) throws AbstractImageException {
            return detectionOp.faceGetGroupIds(request);
    }

    @Override
    public String faceAddGroupIds(FaceAddGroupIdsRequest request) throws AbstractImageException {
            return detectionOp.faceAddGroupIds(request);
    }

    @Override
    public String faceDelGroupIds(FaceDelGroupIdsRequest request) throws AbstractImageException {
            return detectionOp.faceDelGroupIds(request);
    }

    @Override
    public String faceGetPersonIds(FaceGetPersonIdsRequest request) throws AbstractImageException {
            return detectionOp.faceGetPersonIds(request);
    }
    
    @Override
    public String faceGetFaceIds(FaceGetFaceIdsRequest request) throws AbstractImageException {
            return detectionOp.faceGetFaceIds(request);
    }
    
    @Override
    public String faceGetFaceInfo(FaceGetFaceInfoRequest request) throws AbstractImageException {
            return detectionOp.faceGetFaceInfo(request);
    }
    
    @Override
    public String faceIdentify(FaceIdentifyRequest request) throws AbstractImageException {
            return detectionOp.faceIdentify(request);
    }
    
    @Override
    public String faceVerify(FaceVerifyRequest request) throws AbstractImageException {
            return detectionOp.faceVerify(request);
    }
    
    @Override
    public String faceCompare(FaceCompareRequest request) throws AbstractImageException {
            return detectionOp.faceCompare(request);
    }

    @Override
    public String faceMultiIdentify(FaceMultiIdentifyRequest request) throws AbstractImageException {
            return detectionOp.faceMultiIdentify(request);
    }

    @Override
    public String faceIdCardCompare(FaceIdCardCompareRequest request) throws AbstractImageException {
            return detectionOp.faceIdCardCompare(request);
    }
    
     @Override
     public String faceLiveGetFour(FaceLiveGetFourRequest request) throws AbstractImageException {
            return detectionOp.faceLiveGetFour(request);
     }
    
    @Override
    public String faceIdCardLiveDetectFour(FaceIdCardLiveDetectFourRequest request) throws AbstractImageException {
            return detectionOp.faceIdCardLiveDetectFour(request);
    }
    
    @Override
    public String faceLiveDetectFour(FaceLiveDetectFourRequest request) throws AbstractImageException {
            return detectionOp.faceLiveDetectFour(request);
    }
    @Override
    public String faceLiveDetectPicture(FaceLiveDetectPictureRequest request) throws AbstractImageException {
            return detectionOp.faceLiveDetectPicture(request);
    }

    @Override
    public void shutdown() {
        this.client.shutdown();
    }

}
