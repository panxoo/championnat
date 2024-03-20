package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.StadeDao;
import com.ipi.championnat.pojos.Stade;
import com.ipi.championnat.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadeServiceImpl implements StadeService {
    @Autowired
    private StadeDao stadeDao;

    @Override
    public Stade ajouterStade(Stade stade) {
        return stadeDao.save(stade);
    }

    @Override
    public List<Stade> ajouterStades(List<Stade> stades) {
        return stadeDao.saveAll(stades);
    }

    @Override
    public Stade recupererStade(Long idstade) {
        return stadeDao.findById(idstade).orElse(null);
    }

    @Override
    public List<Stade> recupererStade() {
        return stadeDao.findAll();
    }
}
