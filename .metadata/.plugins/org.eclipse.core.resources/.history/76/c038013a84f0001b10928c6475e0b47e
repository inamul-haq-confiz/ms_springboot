package com.test.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.test.demo"))
                .paths(PathSelectors.any())                
                .build()
                .apiInfo(getApiInfo())
                .produces(new HashSet<>(Arrays.asList("application/json")))
                .consumes(new HashSet<>(Arrays.asList("application/json")))
                .securitySchemes(Arrays.asList(apiKey()));

    }
    private ApiInfo getApiInfo() {
    	
    	return new ApiInfoBuilder().title("Shopping Cart Product APIs")
        .description("Shopping Cart Product APIs")
        .termsOfServiceUrl("http://confiz.com")
        .contact(new Contact("Inam ul Haq", "http://confiz.com", "inamul.haq@confiz.com"))
        .license("Test License")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").version("1.0").build();
       
    }
    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }
}