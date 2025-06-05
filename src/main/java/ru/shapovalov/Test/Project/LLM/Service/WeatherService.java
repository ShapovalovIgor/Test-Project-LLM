package ru.shapovalov.Test.Project.LLM.Service;

import io.micrometer.core.ipc.http.HttpSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClient;
import ru.shapovalov.Test.Project.LLM.Properties.WeatherProperties;

import java.util.function.Function;

public class WeatherService implements Function<WeatherService.Request, WeatherService.Response> {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
    private final RestClient restClient;
    private final WeatherProperties properties;

    public WeatherService(WeatherProperties properties) {
        this.properties = properties;
        this.restClient = RestClient.create(properties.apiUrl());
    }

    @Override
    public Response apply(Request request) {
        log.info("API weather Request: {}", request);
        Response response = restClient.get()
                .uri("/current.json?key={key}&q={q}", properties.apiKey(), request.city())
                .retrieve()
                .body(Response.class);
        log.info("API weather Response: {}", response);
        return response;
    }


    public record Request(String city) {
    }

    public record Response(Location location, Current current) {
    }

    public record Location(String name, String region, String country, Long lat, Long lon) {
    }

    public record Current(String temp_f, Condition condition, String wind_mph, String humidity) {
    }

    public record Condition(String text) {
    }
}
