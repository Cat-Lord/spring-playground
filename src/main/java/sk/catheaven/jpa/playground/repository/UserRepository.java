package sk.catheaven.jpa.playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.catheaven.jpa.playground.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
