package com.herald.forumapi.service;

import com.herald.forumapi.model.User;
import com.herald.forumapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User register(String firstname, String lastname) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        return userRepository.save(user);
    }

    public User login(String firstname, String lastname) {
        Optional<User> userOptional = userRepository.findUserByFirstnameAndLastname(firstname, lastname);
        return userOptional.orElse(null);
    }
}
