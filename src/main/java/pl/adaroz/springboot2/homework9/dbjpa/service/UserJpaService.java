package pl.adaroz.springboot2.homework9.dbjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adaroz.springboot2.homework9.model.User;
import pl.adaroz.springboot2.homework9.service.UserService;
import pl.adaroz.springboot2.homework9.dbjpa.model.UserJpa;
import pl.adaroz.springboot2.homework9.dbjpa.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserJpaService implements UserService {

    private UserJpaRepository userJpaRepository;

    @Autowired
    public UserJpaService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void save(User user) {
        userJpaRepository.save((UserJpa) user);
    }

    @Override
    public List findAll() {
        return userJpaRepository.findAll();
    }

}
