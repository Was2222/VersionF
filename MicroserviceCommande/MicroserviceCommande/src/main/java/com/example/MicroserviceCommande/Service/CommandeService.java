package com.example.MicroserviceCommande.Service;

import com.example.MicroserviceCommande.Repository.CommandeRepository;
import com.example.MicroserviceCommande.model.Commande;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    /**
     * Récupère les commandes reçues dans les derniers 'commandesLast' jours.
     *
     * @return Liste des commandes récentes.
     */
    public List<Commande> getRecentCommandes() {
        LocalDate cutoffDate = LocalDate.now().minusDays(commandesLast);
        return commandeRepository.findAll().stream()
                .filter(commande -> commande.getDate().isAfter(cutoffDate))
                .toList();
    }

    /**
     * Crée une nouvelle commande.
     *
     * @param commande Commande à créer.
     * @return Commande créée.
     */
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    /**
     * Récupère toutes les commandes.
     *
     * @return Liste de toutes les commandes.
     */
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    /**
     * Récupère une commande par son ID.
     *
     * @param id ID de la commande.
     * @return Optional contenant la commande si trouvée, sinon vide.
     */
    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    /**
     * Met à jour une commande existante.
     *
     * @param id             ID de la commande à mettre à jour.
     * @param commandeDetails Détails de la commande à mettre à jour.
     * @return Optional contenant la commande mise à jour si elle existe, sinon vide.
     */
    public Optional<Commande> updateCommande(Long id, Commande commandeDetails) {
        return commandeRepository.findById(id).map(commande -> {
            commande.setDescription(commandeDetails.getDescription());
            commande.setQuantite(commandeDetails.getQuantite());
            commande.setDate(commandeDetails.getDate());
            commande.setMontant(commandeDetails.getMontant());
            return commandeRepository.save(commande);
        });
    }

    /**
     * Supprime une commande par son ID.
     *
     * @param id ID de la commande à supprimer.
     * @return true si la suppression a réussi, false si la commande n'existe pas.
     */
    public boolean deleteCommande(Long id) {
        return commandeRepository.findById(id).map(commande -> {
            commandeRepository.delete(commande);
            return true;
        }).orElse(false);
    }

    public boolean hasCommandes() {
        return commandeRepository.count() > 0;
    }
}
