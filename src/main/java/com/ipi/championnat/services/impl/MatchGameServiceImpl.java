package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.MatchGameDao;
import com.ipi.championnat.pojos.Championat;
import com.ipi.championnat.pojos.MatchGame;
import com.ipi.championnat.services.MatchGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchGameServiceImpl implements MatchGameService {
    @Autowired
    private MatchGameDao mathGameDao;

    @Override
    public MatchGame ajouterMatchGame(MatchGame matchgame) {
        return mathGameDao.save(matchgame);
    }

    @Override
    public MatchGame recupererMatchGame(Long idmatch) {
        return mathGameDao.findById(idmatch).orElse(null);
    }

    @Override
    public List<MatchGame> recupererMatchGame() {
        return mathGameDao.findAll();
    }

    @Override
    public List<MatchGame> recupererMatchGame(Championat championat){
        return mathGameDao.findMatchGamesByJourneeChampionat(championat);
    }

}
