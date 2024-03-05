package com.ipi.championnat.services.impl;

import com.ipi.championnat.dao.UserDao;
import com.ipi.championnat.pojos.User;
import com.ipi.championnat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    ;

    @Override
    public User getUser(Long idUser) {
        return userDao.findById(idUser).orElse(null);
    }

    ;

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    ;


}
