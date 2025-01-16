package com.example.MicroserviceProduits.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "mes-config-ms")
public class MesConfigMsProperties {

    private int produitsLast;

    // Getters et Setters
    public int getProduitsLast() {
        return produitsLast;
    }

    public void setProduitsLast(int produitsLast) {
        this.produitsLast = produitsLast;
    }
}
