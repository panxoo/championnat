package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.MathDao;
import com.ipi.championnat.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {
    @Autowired
    private MathDao mathDao;
}
