package com.example.MicroserviceCommande.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer quantite;
    private LocalDate date;
    private Double montant;

    // Constructeur par défaut
    public Commande() {
    }

    // Constructeur avec paramètres
    public Commande(String description, Integer quantite, LocalDate date, Double montant) {
        this.description = description;
        this.quantite = quantite;
        this.date = date;
        this.montant = montant;
    }

    // Getter et Setter pour 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour 'description'
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter et Setter pour 'quantite'
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    // Getter et Setter pour 'date'
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter et Setter pour 'montant'
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    // Optionnel : toString(), equals(), hashCode()
    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", date=" + date +
                ", montant=" + montant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commande)) return false;

        Commande commande = (Commande) o;

        if (getId() != null ? !getId().equals(commande.getId()) : commande.getId() != null) return false;
        if (getDescription() != null ? !getDescription().equals(commande.getDescription()) : commande.getDescription() != null)
            return false;
        if (getQuantite() != null ? !getQuantite().equals(commande.getQuantite()) : commande.getQuantite() != null)
            return false;
        if (getDate() != null ? !getDate().equals(commande.getDate()) : commande.getDate() != null) return false;
        return getMontant() != null ? getMontant().equals(commande.getMontant()) : commande.getMontant() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getQuantite() != null ? getQuantite().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getMontant() != null ? getMontant().hashCode() : 0);
        return result;
    }
}
