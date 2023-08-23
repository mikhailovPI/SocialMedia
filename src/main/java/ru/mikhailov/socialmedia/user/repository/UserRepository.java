package ru.mikhailov.socialmedia.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mikhailov.socialmedia.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u.email from User u")
    List<String> findByNameOrderByEmail();
    Optional<User> findByEmail(String email);

}
