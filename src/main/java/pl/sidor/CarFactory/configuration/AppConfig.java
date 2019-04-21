package pl.sidor.CarFactory.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories("pl.sidor")
@EntityScan("models")
public class AppConfig {

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

}
