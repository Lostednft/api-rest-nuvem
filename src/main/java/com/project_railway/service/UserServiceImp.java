package com.project_railway.service;

import com.project_railway.domain.Repository.UserRepository;
import com.project_railway.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void create(User user) {

        User numberValidation = userRepository.findByCardNumberOrAccountNumber(user.getCard().getNumber(), user.getAccount().getNumber());

        if(numberValidation != null)
            throw new IllegalArgumentException("This user id already exists.");
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
