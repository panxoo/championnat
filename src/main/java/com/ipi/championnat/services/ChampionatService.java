package com.ipi.championnat.services;

import com.ipi.championnat.pojos.Championat;
import com.ipi.championnat.pojos.Pays;

import java.util.List;

public interface ChampionatService {
    Championat ajouterChampionat(Championat championat);
    Championat recupererChampionat(Long idchampionat);
    List<Championat> recupererChampionat();
    Championat recupererChampionat(String nom);
}
