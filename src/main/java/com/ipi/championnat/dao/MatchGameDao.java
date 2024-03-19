package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.MatchGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchGameDao extends JpaRepository<MatchGame, Long> {
}
