package com.jeswin8801.ghibli_lib.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "web")
public class WebConfigProperties {
    private final Cors cors;

    public WebConfigProperties(Cors cors) {
        this.cors = cors;
    }

    public record Cors(String[] allowedOrigins, String[] allowedMethods, String[] allowedHeaders,
                       String[] exposedHeaders) {
        // ...
    }
}
