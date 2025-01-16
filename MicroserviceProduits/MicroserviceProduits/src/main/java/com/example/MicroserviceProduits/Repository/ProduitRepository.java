package com.example.MicroserviceProduits.Repository;


import com.example.MicroserviceProduits.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire
    List<Produit> findAll();

    Produit save(Produit produit);

    void deleteById(Long id);
    boolean existsById(Long id);
    List<Produit> findByDateAjoutAfter(Date date);
}
