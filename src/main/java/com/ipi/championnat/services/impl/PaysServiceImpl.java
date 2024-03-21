package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.PaysDao;
import com.ipi.championnat.pojos.Pays;
import com.ipi.championnat.services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysServiceImpl implements PaysService {
    @Autowired
    private PaysDao paysDao;

    @Override
    public Pays ajouterPays(Pays pays){
        return paysDao.save(pays);
    }
    @Override
    public List<Pays> ajouterPays(List<Pays> pays){
        return paysDao.saveAll(pays);
    }
    @Override
    public Pays recupererPays(Long idpays){
        return paysDao.findById(idpays).orElse(null);
    }
    @Override
    public List<Pays> recupererPays(){
        return paysDao.findAll();
    }

    @Override
    public List<Pays> recupererPaysAvecChampionat(){return paysDao.findPaysWithChampionats();}
}
