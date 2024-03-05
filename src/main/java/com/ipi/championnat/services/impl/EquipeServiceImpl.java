package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.EquipeDao;
import com.ipi.championnat.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeServiceImpl implements EquipeService {
    @Autowired
    private EquipeDao equipeDao;
}
