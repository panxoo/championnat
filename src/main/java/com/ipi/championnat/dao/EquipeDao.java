package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.Equipe;
import com.ipi.championnat.pojos.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long> {
    public Equipe findFirstByNom(String nom);

    @Query("SELECT DISTINCT p FROM Pays p INNER JOIN p.championats")
    List<Pays> findPaysWithChampionats();

}
