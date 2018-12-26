package cn.jadenziv.source.qcloud.image.config.autoconfigure;

import cn.jadenziv.source.qcloud.image.ImageClient;
import cn.jadenziv.source.qcloud.image.config.properties.QcloudProperties;
import cn.jadenziv.source.qcloud.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * @author: jadenziv
 * @date: 2018/12/20 14:27
 */
@Configuration
@EnableConfigurationProperties(QcloudProperties.class)
public class QcloudAutoConfiguration {

    @Autowired
    private QcloudProperties qcloudProperties;

    /**
     * 配置imageClient
     * 当不存在时实例化
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public ImageClient imageClient() {
        ImageClient imageClient = new ImageClient(qcloudProperties.getAppId(), qcloudProperties.getSecretId(), qcloudProperties.getSecretKey(), ImageClient.NEW_DOMAIN_recognition_image_myqcloud_com);
        //是否开启代理
        if (qcloudProperties.getIsEnableProxy()) {
            Proxy proxy = new Proxy(qcloudProperties.getType(), new InetSocketAddress(qcloudProperties.getIp(), qcloudProperties.getHost()));
            imageClient.setProxy(proxy);
        }
        return imageClient;
    }

    /**
     * 当ImageClient存在才初始化
     *
     * @return
     */
    @Bean
    @ConditionalOnBean(ImageClient.class)
    @ConditionalOnMissingBean
    public ImageService imageService() {
        return new ImageService();
    }


}