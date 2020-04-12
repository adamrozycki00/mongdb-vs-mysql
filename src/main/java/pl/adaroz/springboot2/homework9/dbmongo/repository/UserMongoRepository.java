package pl.adaroz.springboot2.homework9.dbmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.adaroz.springboot2.homework9.dbmongo.model.UserMongo;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
}
