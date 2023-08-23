package ru.mikhailov.socialmedia.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikhailov.socialmedia.user.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
