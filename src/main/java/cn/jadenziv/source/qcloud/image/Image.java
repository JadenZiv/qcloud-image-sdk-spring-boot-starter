package cn.jadenziv.source.qcloud.image;

import cn.jadenziv.source.qcloud.image.exception.AbstractImageException;
import cn.jadenziv.source.qcloud.image.request.*;

/**
 * @author chengwu
 * Image提供给用户使用的API接口
 */

public interface Image {

    /**
     * OCR-车牌识别
     */
    String ocrPlate(OcrPlateRequest request)throws AbstractImageException;
    
    /**
     * OCR-银行卡识别
     */
    String ocrBankCard(OcrBankCardRequest request)throws AbstractImageException;
    
    /**
     * OCR-营业执照识别
     */
    String ocrBizLicense(OcrBizLicenseRequest request)throws AbstractImageException;
    
    /**
     * OCR-行驶证驾驶证识别
     */
    String ocrDrivingLicence(OcrDrivingLicenceRequest request)throws AbstractImageException;
    
    /**
     * OCR-通用印刷体识别
     */
    String generalOcr(GeneralOcrRequest request)throws AbstractImageException;

    /**
	 * 黄图识别接口
	 * 
	 * @param request
	 *            黄图识别请求
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */
    String pornDetect(PornDetectRequest request)throws AbstractImageException;
    
    /**
	 *标签识别接口
	 * 
	 * @param request
	 *            标签识别请求
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */
    String tagDetect(TagDetectRequest request)throws AbstractImageException;
    
    /**
	 *身份证识别接口
	 * 
	 * @param request
	 *            身份证识别请求
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */
    String idcardDetect(IdcardDetectRequest request)throws AbstractImageException;
    
        /**
	 *名片识别接口
	 * 
	 * @param request
	 *            名片ocr识别请求
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */
    String namecardDetect(NamecardDetectRequest request)throws AbstractImageException;
    
        /**
	 *人脸检测接口
	 * 
	 * @param request
	 *            人脸检测请求
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */
    String faceDetect(FaceDetectRequest request)throws AbstractImageException;
    
        /**
	 *人脸定位接口
	 * 
	 * @param request
	 *            人脸定位接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */
    String faceShape(FaceShapeRequest request)throws AbstractImageException;
    
        /**
	 *个体创建接口
	 * 
	 * @param request
	 *            个体创建接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceNewPerson(FaceNewPersonRequest request)throws AbstractImageException;
     
     /**
	 *个体删除接口
	 * 
	 * @param request
	 *            个体删除接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceDelPerson(FaceDelPersonRequest request)throws AbstractImageException;
     
      /**
	 *增加人脸接口
	 * 
	 * @param request
	 *            增加人脸接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceAddFace(FaceAddFaceRequest request)throws AbstractImageException;
     
        /**
	 *删除人脸接口
	 * 
	 * @param request
	 *            删除人脸接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceDelFace(FaceDelFaceRequest request)throws AbstractImageException;

     /**
	 *个体设置信息接口
	 * 
	 * @param request
	 *            人脸设置信息接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceSetInfo(FaceSetInfoRequest request)throws AbstractImageException;
     
     /**
	 *个体获取信息接口
	 * 
	 * @param request
	 *            个体获取信息接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceGetInfo(FaceGetInfoRequest request)throws AbstractImageException;
     
      /**
	 *获取组列表接口
	 * 
	 * @param request
	 *            获取组列表接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceGetGroupIds(FaceGetGroupIdsRequest request)throws AbstractImageException;

    /**
     * Person新增组信息 https://cloud.tencent.com/document/product/641/12417
     * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
     * 其他为失败, message为success或者失败原因
     */
    String faceAddGroupIds(FaceAddGroupIdsRequest request)throws AbstractImageException;

    /**
     * Person删除组信息 https://cloud.tencent.com/document/product/641/12417
     * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
     * 其他为失败, message为success或者失败原因
     */
    String faceDelGroupIds(FaceDelGroupIdsRequest request)throws AbstractImageException;
     
      /**
	 *获取人列表接口
	 * 
	 * @param request
	 *            获取人列表接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceGetPersonIds(FaceGetPersonIdsRequest request)throws AbstractImageException;
     
    /**
	 *获取人脸列表接口
	 * 
	 * @param request
	 *            获取人脸列表接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceGetFaceIds(FaceGetFaceIdsRequest request)throws AbstractImageException;
     
      /**
	 *获取人脸信息接口
	 * 
	 * @param request
	 *            获取人脸信息接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceGetFaceInfo(FaceGetFaceInfoRequest request)throws AbstractImageException;
     
       /**
	 *获取人脸识别接口
	 * 
	 * @param request
	 *            获取人脸识别接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceIdentify(FaceIdentifyRequest request)throws AbstractImageException;
     
     /**
	 *人脸验证接口
	 * 
	 * @param request
	 *            人脸验证接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceVerify(FaceVerifyRequest request)throws AbstractImageException;

    /**
     * 人脸对比接口
     * @param request 人脸对比接口
     * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
     * 其他为失败, message为success或者失败原因
     */
    String faceCompare(FaceCompareRequest request)throws AbstractImageException;

    /**
     * 多脸检索
     * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
     * 其他为失败, message为success或者失败原因
     */
    String faceMultiIdentify(FaceMultiIdentifyRequest request)throws AbstractImageException;
     
     /**
	 *身份证对比接口
	 * 
	 * @param request
	 *            身份证对比接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceIdCardCompare(FaceIdCardCompareRequest request)throws AbstractImageException;
     
        /**
	 *获取验证码接口
	 * 
	 * @param request
	 *            获取验证码接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceLiveGetFour(FaceLiveGetFourRequest request)throws AbstractImageException;
     
       /**
	 *身份对比接口
	 * 
	 * @param request
	 *            身份对比接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceIdCardLiveDetectFour(FaceIdCardLiveDetectFourRequest request)throws AbstractImageException;
     
      /**
	 *身份检测接口
	 * 
	 * @param request
	 *            身份检测接口
	 * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
	 *         其他为失败, message为success或者失败原因
	 */    
     String faceLiveDetectFour(FaceLiveDetectFourRequest request)throws AbstractImageException;

    /**
     * 人脸静态活体检测 https://cloud.tencent.com/document/product/641/12558
     * @return JSON格式的字符串, 格式为{"code":$code, "message":"$mess"}, code为0表示成功,
     * 其他为失败, message为success或者失败原因
     */
    String faceLiveDetectPicture(FaceLiveDetectPictureRequest request)throws AbstractImageException;
     
    /**
     * 关闭Image客户端连接池，释放涉及的资源，释放后，不能再使用Image的接口，必须重新生成一个新对象
     */
    void shutdown();

}
