package pl.adaroz.springboot2.homework9.dbmongo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import pl.adaroz.springboot2.homework9.model.User;

import javax.persistence.Id;

@Document
public class UserMongo extends User {

    @Id
    private String id;

    public UserMongo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
