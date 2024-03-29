package com.ipi.championnat.pojos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Journee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    @OneToMany(mappedBy = "journee")
    private List<MatchGame> matchs;
    @ManyToOne
    private Championat championat;

    public Journee(){}
    public Journee(int numero, Championat championat) {
        this.numero = numero;
        this.championat = championat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<MatchGame> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<MatchGame> maths) {
        this.matchs = matchs;
    }

    public Championat getChampionat() {
        return championat;
    }

    public void setChampionat(Championat championat) {
        this.championat = championat;
    }
}
