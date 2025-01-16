package com.example.MicroserviceProduits.Service;


import com.example.MicroserviceProduits.Config.MesConfigMsProperties;
import com.example.MicroserviceProduits.Model.Produit;
import com.example.MicroserviceProduits.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RefreshScope  // Permet le rafraîchissement des propriétés à chaud
@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final MesConfigMsProperties config;

    public ProduitService(ProduitRepository produitRepository, MesConfigMsProperties config) {
        this.produitRepository = produitRepository;
        this.config = config;
    }
    @Value("${mes-config-ms.produits-last}")
    private int produitsLast;
    /**
     * Récupère les produits ajoutés dans les derniers 'produitsLast' jours
     */
    public List<Produit> getRecentProduits() {
        LocalDate cutoffDate = LocalDate.now().minusDays(produitsLast);
        return produitRepository.findAll().stream()
                .filter(produit -> produit.getDateAjout().isAfter(cutoffDate))
                .toList();
    }

    /**
     * Crée un nouveau produit
     */
    public Produit createProduit(Produit produit) {
        produit.setDateAjout(LocalDate.now());
        return produitRepository.save(produit);
    }

    /**
     * Récupère un produit par son ID
     */
    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    /**
     * Met à jour un produit existant
     */
    public Optional<Produit> updateProduit(Long id, Produit produitDetails) {
        return produitRepository.findById(id).map(produit -> {
            produit.setNom(produitDetails.getNom());
            produit.setDescription(produitDetails.getDescription());
            produit.setQuantite(produitDetails.getQuantite());
            produit.setPrix(produitDetails.getPrix());
            // La date d'ajout ne change pas
            return produitRepository.save(produit);
        });
    }

    /**
     * Supprime un produit par son ID
     */
    public boolean deleteProduit(Long id) {
        return produitRepository.findById(id).map(produit -> {
            produitRepository.delete(produit);
            return true;
        }).orElse(false);
    }
}
