package ru.mikhailov.socialmedia.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mikhailov.socialmedia.user.service.UserService;

@RestController
@RequestMapping(path = UserController.URL_USER)
@RequiredArgsConstructor
@Slf4j
public class UserController {
        public static final String URL_USER = "/users";
        public final UserService userService;
}
