package com.example.MicroserviceProduits.Model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private Integer quantite;
    private Double prix;
    private LocalDate dateAjout;

    // Constructors
    public Produit() {
    }

    public Produit(String nom, String description, Integer quantite, Double prix, LocalDate dateAjout) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.dateAjout = dateAjout;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    // ... autres getters et setters

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }
}
