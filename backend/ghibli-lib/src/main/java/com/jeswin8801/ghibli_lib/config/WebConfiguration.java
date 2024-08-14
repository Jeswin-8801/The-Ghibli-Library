package com.jeswin8801.ghibli_lib.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties({ WebConfigProperties.class })
public class WebConfiguration {
    private final WebConfigProperties webConfigProperties;

    public WebConfiguration(WebConfigProperties webConfigProperties) {
        this.webConfigProperties = webConfigProperties;
    }

    @Bean
    public WebMvcConfigurer corsMappingConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                WebConfigProperties.Cors cors = webConfigProperties.getCors();
                registry.addMapping("/**")
                        .allowedOrigins(cors.allowedOrigins())
                        .allowedMethods(cors.allowedMethods())
                        .allowedHeaders(cors.allowedHeaders())
                        .exposedHeaders(cors.exposedHeaders());
            }
        };
    }
}
