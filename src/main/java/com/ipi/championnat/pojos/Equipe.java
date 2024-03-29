package com.ipi.championnat.pojos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
    private String logo;
    @NotBlank(message = "Le nom d'entraineur est obligatoire")
    private String nomEntraineur;
    @NotBlank(message = "Le nom de president est obligatoire")
    private String president;
    private String status;
    private String siege;
    @NotBlank(message = "Le telephone est obligatoire")
    private String telephone;
    @NotBlank(message = "Le site web est obligatoire")
    private String siteWeb;
    @ManyToOne
    private Stade stade;
    @ManyToMany
    @JoinTable(
            name = "championat_equipe",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "championat_id")
    )
    private List<Championat> championates;

   @OneToMany(mappedBy = "equipe1")
    private List<MatchGame> matchs1;

    @OneToMany(mappedBy = "equipe2")
    private List<MatchGame> matchs2;
    public Equipe(){}

    public Equipe(String nom, Date dateCreation, String logo, String nomEntraineur, String president, String status, String siege, String telephone, String siteWeb, Stade stade) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.logo = logo;
        this.nomEntraineur = nomEntraineur;
        this.president = president;
        this.status = status;
        this.siege = siege;
        this.telephone = telephone;
        this.siteWeb = siteWeb;
        this.stade = stade;
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNomEntraineur() {
        return nomEntraineur;
    }

    public void setNomEntraineur(String nomEntraineur) {
        this.nomEntraineur = nomEntraineur;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public List<MatchGame> getMaths1() {
        return matchs1;
    }

    public void setMaths1(List<MatchGame> maths1) {
        this.matchs1 = maths1;
    }

    public List<MatchGame> getMatchs2() {
        return matchs2;
    }

    public void setMatchs2(List<MatchGame> matchs2) {
        this.matchs2 = matchs2;
    }

    public List<Championat> getChampionates() {
        return championates;
    }

    public void setChampionates(List<Championat> championates) {
        this.championates = championates;
    }
}
