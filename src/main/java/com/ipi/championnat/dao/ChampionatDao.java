package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.Championat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionatDao  extends JpaRepository<Championat, Long> {
}
