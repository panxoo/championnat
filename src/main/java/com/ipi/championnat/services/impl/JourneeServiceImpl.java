package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.JourneeDao;
import com.ipi.championnat.services.JourneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JourneeServiceImpl implements JourneeService {
    @Autowired
    private JourneeDao journeeDao;
}
