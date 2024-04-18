package com.capston.v2psmombie.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(getInfo());
    }

    private Info getInfo() {
        return new Info()
                .title("V2P Smombie Service API")
                .description("V2P 기반 스마트폰 스몸비 인식 및 알림 앱 API")
                .version("1.0.0");
    }
}
