package org.sayHello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    //build Bean's of Docket in this function
    @Bean
    public Docket createRestApi() {
    //use apiInfo() to create basic info of this Api
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("hello")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.sayHello.rest"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("sayHello API page")
                .description("I don't know say what")
                .termsOfServiceUrl("www.eugene.com")
                .contact("Yuqi (Eugene) Zhu")
                .license("what the hell is this")
                .version("1.0")
                .build();
    }


}


