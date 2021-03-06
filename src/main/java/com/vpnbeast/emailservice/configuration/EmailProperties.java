package com.vpnbeast.emailservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailProperties {

    private String username;
    private String password;
    private String host;
    private String protocol;
    private Integer port;

}