package ru.shapovalov.Test.Project.LLM.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "weather")
public record WeatherProperties(String apiKey, String apiUrl) {
}
