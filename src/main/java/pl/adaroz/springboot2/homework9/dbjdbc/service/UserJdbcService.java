package pl.adaroz.springboot2.homework9.dbjdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adaroz.springboot2.homework9.dbjdbc.model.UserJdbc;
import pl.adaroz.springboot2.homework9.dbjdbc.repository.UserJdbcRepository;
import pl.adaroz.springboot2.homework9.model.User;
import pl.adaroz.springboot2.homework9.service.UserService;

import java.util.List;

@Service
public class UserJdbcService implements UserService {

    private UserJdbcRepository userJdbcRepository;

    @Autowired
    public UserJdbcService(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    @Override
    public void save(User user) {
        userJdbcRepository.save((UserJdbc) user);
    }

    @Override
    public List findAll() {
        return userJdbcRepository.findAll();
    }

}
