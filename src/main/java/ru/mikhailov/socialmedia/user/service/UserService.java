package ru.mikhailov.socialmedia.user.service;

import ru.mikhailov.socialmedia.user.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    void addFriends(Long userId, Long friendId);

    void deleteFriends(Long userId, Long friendId);
}
