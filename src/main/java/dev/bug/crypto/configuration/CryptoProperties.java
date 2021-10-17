package dev.bug.crypto.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Getter
@Setter
@ConfigurationProperties("crypto")
public class CryptoProperties {

    private String host;
    private String path;

    public URI getCryptoUrl() {
        return URI.create(host + path);
    }
}
