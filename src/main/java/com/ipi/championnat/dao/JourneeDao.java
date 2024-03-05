package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.Journee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneeDao extends JpaRepository<Journee, Long> {
}
