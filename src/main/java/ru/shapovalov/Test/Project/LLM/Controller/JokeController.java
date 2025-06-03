package ru.shapovalov.Test.Project.LLM.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    private final ChatClient chatClient;

    public JokeController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("")
    public String getJoke() {
        return chatClient.prompt()
                .user("Пожалуйста расскажи мне шутку про JAVA программиста")
                .call()
                .content();
    }
}
