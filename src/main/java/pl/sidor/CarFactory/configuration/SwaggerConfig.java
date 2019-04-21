package pl.sidor.CarFactory.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.sidor.CarFactory.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(ApInfo());
    }

    private ApiInfo ApInfo() {

        return new ApiInfo(
                "Witaj w moim API",
                "API Fabryki samochodowej",
                "Wersja I",
                "Terms of service",
                new Contact("Karol Sidor", "www.wp.pl", "karolsidor11@wp.pl"),
                "Licencja  API", "API license URL", Collections.emptyList());
    }
}
