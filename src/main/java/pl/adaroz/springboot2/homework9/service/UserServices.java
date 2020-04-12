package pl.adaroz.springboot2.homework9.service;

import org.springframework.stereotype.Service;
import pl.adaroz.springboot2.homework9.dbjdbc.model.UserJdbc;
import pl.adaroz.springboot2.homework9.dbjdbc.service.UserJdbcService;
import pl.adaroz.springboot2.homework9.dbjpa.model.UserJpa;
import pl.adaroz.springboot2.homework9.dbjpa.service.UserJpaService;
import pl.adaroz.springboot2.homework9.dbmongo.model.UserMongo;
import pl.adaroz.springboot2.homework9.dbmongo.service.UserMongoService;
import pl.adaroz.springboot2.homework9.model.User;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

@Service
public class UserServices {

    public void getAllFromCsvAndSave(UserService userService, Path csvFilePath) {
        long start = 0;
        long end = 0;
        try (Scanner input = new Scanner(csvFilePath)) {
            input.nextLine(); //ignore the 1st row containing headers
            start = System.currentTimeMillis();
            while (input.hasNextLine()) {
                String[] fields = input.nextLine().split(",");
                User user;
                if (userService instanceof UserJpaService) {
                    UserJpa userJpa = new UserJpa();
                    userJpa.setId(Long.parseLong(fields[0]));
                    user = userJpa;
                } else if (userService instanceof UserJdbcService) {
                    UserJdbc userJdbc = new UserJdbc();
                    userJdbc.setId(Long.parseLong(fields[0]));
                    user = userJdbc;
                } else if (userService instanceof UserMongoService) {
                    UserMongo userMongo = new UserMongo();
                    userMongo.setId(fields[0]);
                    user = userMongo;
                } else throw new IllegalArgumentException("Unknown service");
                setFields(user, fields);
                userService.save(user);
            }
            end = System.currentTimeMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf(userService.getClass().getSimpleName() + ", time elapsed: %d%n", end - start);
    }

    public void findAll(UserService userService) {
        long start = 0;
        long end = 0;
        List<User> users;
            start = System.currentTimeMillis();
                    users = userService.findAll();
        end = System.currentTimeMillis();
        System.out.printf(userService.getClass().getSimpleName() + ", time elapsed: %d%n", end - start);
    }

    private void setFields(User user, String[] fields) {
        user.setFirstName(fields[1]);
        user.setLastName(fields[2]);
        user.setEmail(fields[3]);
        user.setGender(fields[4]);
        user.setIpAddress(fields[5]);
    }

}
