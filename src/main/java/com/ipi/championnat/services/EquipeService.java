package com.ipi.championnat.services;

import com.ipi.championnat.pojos.Equipe;
import com.ipi.championnat.pojos.Stade;

import java.util.List;

public interface EquipeService {
    Equipe addEquipe(Equipe equipe);

    Equipe updateEquipe(Long id, Equipe newData);

    Equipe getEquipe(Long idEquipe);

    List<Equipe> getEquipes();

}
