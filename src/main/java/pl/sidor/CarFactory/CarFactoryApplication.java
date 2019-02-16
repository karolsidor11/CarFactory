package pl.sidor.CarFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@ComponentScan("pl.sidor")
public class CarFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarFactoryApplication.class, args);
	}

}

