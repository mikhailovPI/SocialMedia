package ru.mikhailov.socialmedia.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mikhailov.socialmedia.user.dto.UserDto;
import ru.mikhailov.socialmedia.user.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public void addFriends(Long userId, Long friendId) {

    }

    @Override
    public void deleteFriends(Long userId, Long friendId) {

    }
}
