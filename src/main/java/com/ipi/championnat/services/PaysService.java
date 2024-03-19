package com.ipi.championnat.services;

import com.ipi.championnat.pojos.Pays;

import java.util.List;

public interface PaysService {
    Pays ajouterPays(Pays pays);
    List<Pays> ajouterPays(List<Pays> payses);

    Pays recupererPays(Long idpays);
    List<Pays> recupererPays();
}
