package com.example.MicroserviceProduits.Contrôleur;

import com.example.MicroserviceProduits.Model.Produit;
import com.example.MicroserviceProduits.Service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    /**
     * Récupère tous les produits récents
     */
    @GetMapping
    public List<Produit> getAllProduits() throws InterruptedException {
        // Simulate a delay (e.g., 5 seconds)
        Thread.sleep(5000);
        return produitService.getRecentProduits();
    }

    /**
     * Crée un nouveau produit
     */
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }

    /**
     * Récupère un produit par son ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Met à jour un produit existant
     */
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        return produitService.updateProduit(id, produitDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime un produit par son ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        if (produitService.deleteProduit(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
