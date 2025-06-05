package ru.shapovalov.Test.Project.LLM.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.shapovalov.Test.Project.LLM.Properties.WeatherProperties;
import ru.shapovalov.Test.Project.LLM.Service.WeatherService;

import java.util.function.Function;

@Configuration
public class FunctionConfig {

    public final WeatherProperties properties;

    public FunctionConfig(WeatherProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Function<WeatherService.Request, WeatherService.Response> weatherService() {
        return new WeatherService(properties);
    }
}
