package dev.bug.crypto.web.controller;

import dev.bug.crypto.service.CryptoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/cryptos")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping
    public ResponseEntity<String> getAllCryptos() {
        return cryptoService.getCryptos()
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
