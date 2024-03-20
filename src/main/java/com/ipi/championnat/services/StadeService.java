package com.ipi.championnat.services;

import com.ipi.championnat.pojos.Stade;

import java.util.List;

public interface StadeService {
    Stade ajouterStade(Stade stade);

    List<Stade> ajouterStades(List<Stade> stades);

    Stade recupererStade(Long idstade);

    List<Stade> recupererStade();
}
