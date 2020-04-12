package pl.adaroz.springboot2.homework9.dbjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adaroz.springboot2.homework9.dbjpa.model.UserJpa;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpa, Long> {
}
