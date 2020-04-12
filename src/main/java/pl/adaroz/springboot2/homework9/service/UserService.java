package pl.adaroz.springboot2.homework9.service;

import pl.adaroz.springboot2.homework9.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List findAll();

}
