package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaysDao extends JpaRepository<Pays, Long> {

    @Query("SELECT DISTINCT p FROM Pays p INNER JOIN p.championats")
    List<Pays> findPaysWithChampionats();
}
