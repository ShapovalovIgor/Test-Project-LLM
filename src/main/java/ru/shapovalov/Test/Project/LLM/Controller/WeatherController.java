package ru.shapovalov.Test.Project.LLM.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final ChatClient chatClient;

    public WeatherController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem("Расскажи пожалуйста какая сейчас погода в Moscow")
                .defaultToolNames("weatherService")
                .build();
    }

    @GetMapping("/weather")
    public String weather(@RequestParam String city) {
        return chatClient.prompt()
                .user(city)
                .call()
                .content();
    }
}
