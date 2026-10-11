package com.yupi.airagchat.controller;

import com.yupi.airagchat.ai.AiCodeServiceHelper;
import jakarta.annotation.Resource;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiCodeServiceHelper aiCodeServiceHelper;

    @GetMapping("/chat")
    public Flux<ServerSentEvent<String>> chat(int memoryId, String message) {
        return aiCodeServiceHelper.chatStream(memoryId, message)
                .map(chunk -> ServerSentEvent.<String>builder()
                        .data(chunk)
                        .build());
    }
}
