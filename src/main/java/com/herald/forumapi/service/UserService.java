package com.herald.forumapi.service;

import com.herald.forumapi.model.User;
import com.herald.forumapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(String firstname, String lastname) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        return userRepository.save(user);
    }
}
