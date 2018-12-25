package cn.jadenziv.source.qcloud.image.exception;

// 服务端异常(如返回404deng)
public class ServerException extends AbstractImageException {

    private static final long serialVersionUID = -4536038808919814914L;

    public ServerException(Throwable cause) {
        super(cause.getMessage(), cause, ImageExceptionType.SERVER_EXCEPTION);
    }

    public ServerException(String message) {
        super(ImageExceptionType.SERVER_EXCEPTION, message);
    }

}
