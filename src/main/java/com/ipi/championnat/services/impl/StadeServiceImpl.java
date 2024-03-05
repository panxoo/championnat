package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.StadeDao;
import com.ipi.championnat.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadeServiceImpl implements StadeService {
@Autowired
    private StadeDao stadeDao;
}
