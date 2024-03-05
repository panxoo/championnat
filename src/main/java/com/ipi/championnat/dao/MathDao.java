package com.ipi.championnat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MathDao extends JpaRepository<Math, Long> {
}
