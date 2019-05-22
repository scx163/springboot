package com.backstage.base.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

/**
 * 微信公众号主配置
 */
@Configuration
@PropertySource(value = {"classpath:Wx/wx.properties"})
public class WxMpConfig {

    @Value("${appId}")
    private String appId;
    @Value("${appSecret}")
    private String appSecret;
    @Value("${token}")
    private String token;
    @Value("${aesKey}")
    private String aesKey;

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
        configStorage.setAppId(this.appId);
        configStorage.setSecret(this.appSecret);
        configStorage.setToken(this.token);
        configStorage.setAesKey(this.aesKey);
        return configStorage;
    }

    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }
}
