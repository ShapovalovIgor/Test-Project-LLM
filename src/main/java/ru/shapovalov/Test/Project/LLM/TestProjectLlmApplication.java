package ru.shapovalov.Test.Project.LLM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.shapovalov.Test.Project.LLM.Properties.WeatherProperties;

@EnableConfigurationProperties(WeatherProperties.class)
@SpringBootApplication
public class TestProjectLlmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestProjectLlmApplication.class, args);
	}

}
