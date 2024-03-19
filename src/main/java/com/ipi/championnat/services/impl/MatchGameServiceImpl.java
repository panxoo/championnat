package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.MatchGameDao;
import com.ipi.championnat.services.MatchGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchGameServiceImpl implements MatchGameService {
    @Autowired
    private MatchGameDao mathGameDao;
}
