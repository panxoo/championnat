package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.ChampionatDao;
import com.ipi.championnat.pojos.Championat;
import com.ipi.championnat.services.ChampionatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionatServiceImpl implements ChampionatService {

    @Autowired
    private ChampionatDao championatDao;
    @Override
    public Championat ajouterChampionat(Championat championat){
        return championatDao.save(championat);
    }
    @Override
    public Championat recupererChampionat(Long idchampionat){
        return  championatDao.findById(idchampionat).orElse(null);
    }
    @Override
    public List<Championat> recupererChampionat(){
        return  championatDao.findAll();
    }

}
