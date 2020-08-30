package com.pencil.service;

import com.pencil.pojo.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public List<User> findList();
}
