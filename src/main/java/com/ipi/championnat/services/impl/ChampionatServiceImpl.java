package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.ChampionatDao;
import com.ipi.championnat.services.ChampionatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampionatServiceImpl implements ChampionatService {

    @Autowired
    private ChampionatDao championatDao;

}
