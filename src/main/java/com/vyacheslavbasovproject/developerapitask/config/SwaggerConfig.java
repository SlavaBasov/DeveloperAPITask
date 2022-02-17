package com.vyacheslavbasovproject.developerapitask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vyacheslavbasovproject.developerapitask.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title ("DeveloperAPITask with Swagger2 RESTful API")
                .contact(new Contact("Vyacheslav Basov", "https://www.linkedin.com/in/vyacheslav-basov-54517320a", "slavabasov987@gmail.com"))
                .description ("This is a simple REST API. You can create, read, update, delete developers.")
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }

}
