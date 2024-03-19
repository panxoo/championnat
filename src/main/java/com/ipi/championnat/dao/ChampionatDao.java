package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.Championat;
import com.ipi.championnat.pojos.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionatDao  extends JpaRepository<Championat, Long> {
    public List<Championat> findChampionatsByPays(Pays pays);
}
