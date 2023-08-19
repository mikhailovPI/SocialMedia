package ru.mikhailov.socialmedia.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.socialmedia.user.dto.UserDto;
import ru.mikhailov.socialmedia.user.service.UserService;

@RestController
@RequestMapping(path = UserController.URL_USER)
@RequiredArgsConstructor
@Slf4j
public class UserController {
        public static final String URL_USER_R = "/registration/user";
        public static final String URL_USER = "/user";
        public final UserService userService;

        @PostMapping(path = URL_USER_R)
        public UserDto createUser(@RequestBody UserDto userDto) {
                log.info("URL: /registration/users. " +
                        "PostMapping/Создание пользователя/createUser");
                return userService.createUser(userDto);
        }

        @PutMapping(value = URL_USER +  "/{userId}/friends/{friendId}")
        public void addFriends(
                @PathVariable Long userId,
                @PathVariable Long friendId) {
                log.info("URL: /users. PutMapping/Создание пользователя/createUser");
                userService.addFriends(userId, friendId);
        }

        @DeleteMapping(value = URL_USER + "/{userId}/friends/{friendId}")
        public void deleteFriends(
                @PathVariable Long userId,
                @PathVariable Long friendId) {
                userService.deleteFriends(userId, friendId);
        }
}
