package com.ipi.championnat.pojos;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class MatchGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int pointsEquipe1;
    private int pointsEquipe2;
    @ManyToOne
    @JoinColumn
    private Equipe equipe1;
    @ManyToOne
    @JoinColumn
    private Equipe equipe2;
    @ManyToOne
    private Journee journee;

    @ManyToOne
    private Stade stade;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date DateMatchs;

    public MatchGame() {
    }

    public MatchGame(Equipe equipe1, Equipe equipe2, Journee journee, Date dateMatchs, Stade stade) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.journee = journee;
        this.DateMatchs = dateMatchs;
        this.stade = stade;
    }

    public MatchGame(int pointsEquipe1, int pointsEquipe2, Equipe equipe1, Equipe equipe2, Journee journee, Date dateMatchs, Stade stade) {
        this.pointsEquipe1 = pointsEquipe1;
        this.pointsEquipe2 = pointsEquipe2;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.journee = journee;
        this.DateMatchs = dateMatchs;
        this.stade = stade;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPointsEquipe1() {
        return pointsEquipe1;
    }

    public void setPointsEquipe1(int pointsEquipe1) {
        this.pointsEquipe1 = pointsEquipe1;
    }

    public int getPointsEquipe2() {
        return pointsEquipe2;
    }

    public void setPointsEquipe2(int pointsEquipe2) {
        this.pointsEquipe2 = pointsEquipe2;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public Journee getJournee() {
        return journee;
    }

    public void setJournee(Journee journee) {
        this.journee = journee;
    }

    public Date getDateMatchs() {
        return DateMatchs;
    }

    public void setDateMatchs(Date dateMatchs) {
        DateMatchs = dateMatchs;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }
}
