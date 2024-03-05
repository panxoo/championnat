package com.ipi.championnat.dao;

import com.ipi.championnat.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByPseudo(String pseudo);
}
