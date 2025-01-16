package com.example.MicroserviceCommande.Controller;

import com.example.MicroserviceCommande.Service.CommandeService;
import com.example.MicroserviceCommande.model.Commande;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getRecentCommandes();
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.createCommande(commande);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commandeDetails) {
        return commandeService.updateCommande(id, commandeDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        if (commandeService.deleteCommande(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
