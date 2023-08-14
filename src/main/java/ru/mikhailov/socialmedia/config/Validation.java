package ru.mikhailov.socialmedia.config;

import ru.mikhailov.socialmedia.exception.ValidationException;
import ru.mikhailov.socialmedia.user.model.User;

public class Validation {

    public static void validationBodyUser(User user) {
        if (user.getEmail() == null) {
            throw new ValidationException("E-mail не должен быть пустым.");
        }
        if (!user.getEmail().contains("@")) {
            throw new ValidationException("Введен некорректный e-mail.");
        }
        if (user.getPassword() == null) {
            throw new ValidationException("Пароль не должен быть пустым.");
        }
    }
}
