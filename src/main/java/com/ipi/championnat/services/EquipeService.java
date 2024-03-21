package com.ipi.championnat.services;

import com.ipi.championnat.pojos.Equipe;
import com.ipi.championnat.pojos.Pays;

import java.util.List;

public interface EquipeService {
    Equipe ajouterEquipe(Equipe equipe);
    Equipe recupererEquipe(Long idequipe);
    List<Equipe> recupererEquipes();
    Equipe recupererEquipeByNom(String nom);

    List<Equipe> findAllById(List<Long> ids);
}
