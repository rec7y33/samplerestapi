package com.tymm.samplerestapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author cheong.tymm
 */
@Configuration
@EnableConfigurationProperties
@Getter
@Setter
@ConfigurationProperties(prefix = "service") 
public class ServiceConfig {
    private String other_endpoint_1;
}
