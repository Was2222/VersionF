package com.example.ApiGateway.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/gateway")
    public class GatewayController {

    private final RestTemplate restTemplate;

    public GatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/produits")
    @CircuitBreaker(name = "produitsService", fallbackMethod = "produitsFallback")
    public List<Object> getProduitsFromService() {
        String url = "http://microservice-produits/api/produits";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Object> produitsFallback(Throwable throwable) {
        return Collections.singletonList("Fallback: Service is currently unavailable.");
    }
}
