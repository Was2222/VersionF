package com.example.MicroserviceCommande.Repository;



import com.example.MicroserviceCommande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findAll();

    Commande save(Commande commande);

    void deleteById(Long id);
    boolean existsById(Long id);
    List<Commande> findByDateAfter(Date date);
}
