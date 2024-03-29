package com.ipi.championnat.pojos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Championat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    private String logo;
    // @NotBlank(message = "Le date début est obligatoire")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    // @NotBlank(message = "Le date fin est obligatoire")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    @Positive(message = "point superior à 0")
    private int pointGagne;
    @NegativeOrZero(message = "point mois 1")
    private int pointPerdu;

    private int pointNul;
    private String typeClassement;
    @ManyToOne
    private Pays pays;
    @OneToMany(mappedBy = "championat")
    private List<Journee> journees;

    @ManyToMany(mappedBy = "championates")
    private List<Equipe> equipes;

    public Championat() {
    }

    public Championat(String nom, String logo, Date dateDebut, Date dateFin, int pointGagne, int pointPerdu, int pointNul, String typeClassement, Pays pays) {
        this.nom = nom;
        this.logo = logo;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.pointGagne = pointGagne;
        this.pointPerdu = pointPerdu;
        this.pointNul = pointNul;
        this.typeClassement = typeClassement;
        this.pays = pays;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getPointGagne() {
        return pointGagne;
    }

    public void setPointGagne(int pointGagne) {
        this.pointGagne = pointGagne;
    }

    public int getPointPerdu() {
        return pointPerdu;
    }

    public void setPointPerdu(int pointPerdu) {
        this.pointPerdu = pointPerdu;
    }

    public int getPointNul() {
        return pointNul;
    }

    public void setPointNul(int pointNul) {
        this.pointNul = pointNul;
    }

    public String getTypeClassement() {
        return typeClassement;
    }

    public void setTypeClassement(String typeClassement) {
        this.typeClassement = typeClassement;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Journee> getJournees() {
        return journees;
    }

    public void setJournees(List<Journee> journees) {
        this.journees = journees;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
}
