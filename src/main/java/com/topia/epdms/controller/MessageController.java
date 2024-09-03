package com.topia.epdms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/message")
public class MessageController {

    @GetMapping
    public Mono<String> message() {
        return Mono.just("Hello");
    }
}
