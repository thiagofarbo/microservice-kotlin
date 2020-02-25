package com.example.rest.kotlin.config

import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example")).paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

    fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title("API Card")
                .description("API Card").version("1.0").build();
    }
}