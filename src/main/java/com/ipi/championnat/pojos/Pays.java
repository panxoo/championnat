package com.ipi.championnat.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le logo est obligatoire")
    private String logo;
    @OneToMany(mappedBy = "pays")
    private List<Championat> championats;

    public Pays() {
    }

    public Pays(String nom, String logo) {
        this.nom = nom;
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Championat> getChampionats() {
        return championats;
    }

    public void setChampionats(List<Championat> championats) {
        this.championats = championats;
    }
}
