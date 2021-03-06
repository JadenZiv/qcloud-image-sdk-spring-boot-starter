package cn.jadenziv.source.qcloud.image.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.Proxy;


/**
 * 配置文件需要配置的参数
 *
 * @author jadenziv
 * @date 2018/12/20 14:29
 */
@ConfigurationProperties(prefix = "qcloud.image")
@Data
public class QcloudProperties {
    private String appId;
    private String secretId;
    private String secretKey;

    /**
     * The default is not to open the proxy
     */
    private Boolean isEnableProxy = false;
    private Proxy.Type type;
    private String ip;
    private Integer host;
}