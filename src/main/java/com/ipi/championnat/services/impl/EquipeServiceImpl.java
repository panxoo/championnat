package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.EquipeDao;
import com.ipi.championnat.pojos.Equipe;
import com.ipi.championnat.pojos.User;
import com.ipi.championnat.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeDao equipeDao;

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeDao.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Long id, Equipe newData) {
        return equipeDao.save(newData);
    }

    @Override
    public Equipe getEquipe(Long idEquipe) {
        return equipeDao.findById(idEquipe).orElse(null);
    }

    @Override
    public List<Equipe> getEquipes() {
        return equipeDao.findAll();
    }
}
