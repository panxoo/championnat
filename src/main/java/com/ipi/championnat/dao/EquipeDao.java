package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long> {
    Equipe updateEquipeById(Long id);
}
