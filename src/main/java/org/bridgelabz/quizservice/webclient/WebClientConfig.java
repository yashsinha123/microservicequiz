package org.bridgelabz.quizservice.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient quizWebClient() {
        return WebClient.create("http://localhost:8082"); // Assuming quizservice runs on port 8082
    }
}
