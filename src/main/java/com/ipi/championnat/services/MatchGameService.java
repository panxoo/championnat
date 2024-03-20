package com.ipi.championnat.services;


import com.ipi.championnat.pojos.Championat;
import com.ipi.championnat.pojos.MatchGame;

import java.util.List;

public interface MatchGameService {

    MatchGame ajouterMatchGame(MatchGame matchgame);

    MatchGame recupererMatchGame(Long idmatch);

    List<MatchGame> recupererMatchGame();
    List<MatchGame> recupererMatchGame(Championat championat);
}
