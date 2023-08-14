package ru.mikhailov.socialmedia.user.mapper;

import ru.mikhailov.socialmedia.user.dto.UserDto;
import ru.mikhailov.socialmedia.user.model.User;

import java.util.HashSet;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getUserRole()
        );
    }

    public static User toUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getUserRole(),
                new HashSet<>()
        );
    }
}
