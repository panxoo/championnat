package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.EquipeDao;
import com.ipi.championnat.pojos.Equipe;
import com.ipi.championnat.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {
    @Autowired
    private EquipeDao equipeDao;

    @Override
    public Equipe ajouterEquipe(Equipe equipe){ return equipeDao.save(equipe);}
    @Override
    public Equipe recupererEquipe(Long idequipe) { return  equipeDao.findById(idequipe).orElse(null);}
    @Override
    public List<Equipe> recupererEquipes(){ return  equipeDao.findAll();}
    @Override
   public Equipe recupererEquipeByNom(String nom){return  equipeDao.findFirstByNom(nom);}
}
