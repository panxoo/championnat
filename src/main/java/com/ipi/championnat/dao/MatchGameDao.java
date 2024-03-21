package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.Championat;
import com.ipi.championnat.pojos.MatchGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchGameDao extends JpaRepository<MatchGame, Long> {
    public List<MatchGame> findMatchGamesByJourneeChampionat(Championat championat);

}
