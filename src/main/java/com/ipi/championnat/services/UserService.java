package com.ipi.championnat.services;

import com.ipi.championnat.pojos.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User getUser(Long idUser);

    List<User> getUsers();

    User connexionUser(String login, String mdp);

    User getUser(String pseudo);
}
