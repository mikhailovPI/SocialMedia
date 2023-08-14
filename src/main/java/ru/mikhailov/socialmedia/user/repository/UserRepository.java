package ru.mikhailov.socialmedia.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikhailov.socialmedia.user.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
