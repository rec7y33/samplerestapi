package com.tymm.samplerestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;

/**
 *
 * @author cheong.tymm
 */
@Configuration
public class LogbookConfig {

    @Bean
    public Logbook logbook() {
        Logbook logbook = Logbook.builder()
            .build();
        return logbook;
    }
}
