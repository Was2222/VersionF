package com.example.MicroserviceCommande.health;
import com.example.MicroserviceCommande.Service.CommandeService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    private final CommandeService commandeService;

    public CommandeHealthIndicator(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @Override
    public Health health() {
        if (commandeService.hasCommandes()) {
            return Health.up().withDetail("Commandes", "Présentes").build();
        } else {
            return Health.down().withDetail("Commandes", "Absentes").build();
        }
    }
}
