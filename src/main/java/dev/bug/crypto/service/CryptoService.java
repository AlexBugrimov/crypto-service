package dev.bug.crypto.service;

import dev.bug.crypto.configuration.CryptoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@EnableConfigurationProperties(CryptoProperties.class)
public class CryptoService {

    private final RestTemplate restTemplate;
    private final CryptoProperties properties;

    public CryptoService(RestTemplate restTemplate,
                         CryptoProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    public Optional<ResponseEntity<String>> getCryptos() {
        ResponseEntity<String> response = restTemplate.getForEntity(properties.getCryptoUrl(), String.class);
        return Optional.of(response);
    }
}
