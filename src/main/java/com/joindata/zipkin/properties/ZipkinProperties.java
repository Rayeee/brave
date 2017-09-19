package com.joindata.zipkin.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rayee on 2017/9/19.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "com.zipkin")
public class ZipkinProperties {

    private String serviceName;

    private String url;

    private int connectTimeout;

    private int readTimeout;

    private int flushInterval;

    private boolean compressionEnabled;

}
