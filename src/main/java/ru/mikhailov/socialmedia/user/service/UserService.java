package ru.mikhailov.socialmedia.user.service;

import org.springframework.stereotype.Service;
import ru.mikhailov.socialmedia.user.dto.UserDto;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto);

    void addFriends(Long userId, Long friendId);

    void deleteFriends(Long userId, Long friendId);
}
