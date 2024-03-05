package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.PaysDao;
import com.ipi.championnat.services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaysServiceImpl implements PaysService {
    @Autowired
    private PaysDao paysDao;
}
