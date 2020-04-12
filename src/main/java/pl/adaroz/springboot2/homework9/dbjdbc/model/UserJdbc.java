package pl.adaroz.springboot2.homework9.dbjdbc.model;

import pl.adaroz.springboot2.homework9.model.User;

import javax.persistence.*;

@Entity
@Table(name = "users_jdbc")
public class UserJdbc extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UserJdbc() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
