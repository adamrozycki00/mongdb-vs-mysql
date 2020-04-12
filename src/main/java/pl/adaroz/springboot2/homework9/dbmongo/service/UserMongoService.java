package pl.adaroz.springboot2.homework9.dbmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adaroz.springboot2.homework9.model.User;
import pl.adaroz.springboot2.homework9.dbmongo.model.UserMongo;
import pl.adaroz.springboot2.homework9.dbmongo.repository.UserMongoRepository;
import pl.adaroz.springboot2.homework9.service.UserService;

import java.util.List;

@Service
public class UserMongoService implements UserService {

    private UserMongoRepository userMongoRepository;

    @Autowired
    public UserMongoService(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public void save(User user) {
        userMongoRepository.save((UserMongo) user);
    }

    @Override
    public List findAll() {
        return userMongoRepository.findAll();
    }

}
