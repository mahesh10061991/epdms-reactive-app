package com.topia.epdms.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/message")
public class MessageController {

    @GetMapping
    @CircuitBreaker(name = "messageCircuitBreaker", fallbackMethod = "messageDefaultResponse")
    public Mono<String> message() {
        return Mono.just("Hello");
    }

    public Mono<Object> messageDefaultResponse(Throwable throwable) {
        String defaultResponse  = "Message service unavailable!";
        return Mono.just(defaultResponse);
    }
}
