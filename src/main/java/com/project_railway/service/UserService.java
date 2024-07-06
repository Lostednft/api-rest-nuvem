package com.project_railway.service;

import com.project_railway.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(String id);
    void create(User user);
    List<User> findAllUsers();
}
