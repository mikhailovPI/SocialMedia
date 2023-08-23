package ru.mikhailov.socialmedia.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mikhailov.socialmedia.exception.ConflictingRequestException;
import ru.mikhailov.socialmedia.user.dto.UserDto;
import ru.mikhailov.socialmedia.user.model.Role;
import ru.mikhailov.socialmedia.user.model.User;
import ru.mikhailov.socialmedia.user.repository.RoleRepository;
import ru.mikhailov.socialmedia.user.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

import static ru.mikhailov.socialmedia.config.Validation.validationBodyUser;
import static ru.mikhailov.socialmedia.user.mapper.UserMapper.toUser;
import static ru.mikhailov.socialmedia.user.mapper.UserMapper.toUserDto;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        validationBodyUser(toUser(userDto));
        User user = toUser(userDto);
        if (userRepository.findByNameOrderByEmail()
                .stream()
                .noneMatch(email -> email.equals(userDto.getEmail()))) {
            Set<Role> roles = new HashSet<>();
            Set<Role> roleUserDto = userDto.getUserRole();

            if (roleRepository.findAll().isEmpty()) {
                user.setUserRole(roleUserDto);
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                user = userRepository.save(user);
                return toUserDto(user);
            }
            for (Role role : roleUserDto) {
                Role roleFromDataBase = roleRepository.findByName(role.getName());
                if (roleFromDataBase != null) {
                    roles.add(roleFromDataBase);
                } else {
                    roles.add(role);
                }
            }
            user.setUserRole(roles);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user = userRepository.save(user);
        } else {
            throw new ConflictingRequestException(
                    String.format("Пользователь с email:  %s - уже существует!", userDto.getEmail()));
        }
        return toUserDto(user);
    }

    @Override
    public void addFriends(Long userId, Long friendId) {

    }

    @Override
    public void deleteFriends(Long userId, Long friendId) {

    }
}
