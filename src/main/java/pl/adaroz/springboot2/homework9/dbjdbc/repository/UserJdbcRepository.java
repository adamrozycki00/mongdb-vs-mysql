package pl.adaroz.springboot2.homework9.dbjdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.adaroz.springboot2.homework9.dbjdbc.model.UserJdbc;
import pl.adaroz.springboot2.homework9.model.User;
import pl.adaroz.springboot2.homework9.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserJdbcRepository implements UserService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "insert into users_jdbc (first_name, last_name, email, gender, ip_address) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getGender(), user.getIpAddress());
    }

    @Override
    public List findAll() {
        List<UserJdbc> userList = new ArrayList<>();
        String sql = "select * from users_jdbc";
        List<Map<String, Object>> userMaps = jdbcTemplate.queryForList(sql);
        userMaps.stream().forEach(userMap -> {
            UserJdbc user = new UserJdbc();
            user.setId(Long.parseLong(String.valueOf(userMap.get("id"))));
            user.setFirstName(String.valueOf(userMap.get("first_name")));
            user.setLastName(String.valueOf(userMap.get("last_name")));
            user.setEmail(String.valueOf(userMap.get("email")));
            user.setGender(String.valueOf(userMap.get("gender")));
            user.setIpAddress(String.valueOf(userMap.get("ip_address")));
            userList.add(user);
        });
        return userList;
    }
}
