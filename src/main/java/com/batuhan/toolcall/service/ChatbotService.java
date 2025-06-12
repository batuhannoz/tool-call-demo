package com.batuhan.toolcall.service;

import com.batuhan.toolcall.tools.DateTimeTools;
import com.batuhan.toolcall.tools.WeatherTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    private final ChatClient chatClient;

    public ChatbotService(ChatClient.Builder modelBuilder) {
        this.chatClient = modelBuilder
            .defaultTools(new DateTimeTools(), new WeatherTools())
            .build();
    }

    public String handleMessage(String message) {
        return this.chatClient.prompt()
            .user(message)
            .call()
            .content();
    }

}
