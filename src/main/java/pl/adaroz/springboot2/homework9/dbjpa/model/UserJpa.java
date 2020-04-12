package pl.adaroz.springboot2.homework9.dbjpa.model;

import pl.adaroz.springboot2.homework9.model.User;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserJpa extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UserJpa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
