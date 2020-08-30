package com.pencil.service.impl;

import com.pencil.dao.UserDao;
import com.pencil.pojo.User;
import com.pencil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(User user){
        userDao.save(user);
    }

    @Override
    public List<User> findList() {
        return userDao.findAll();
    }

}
