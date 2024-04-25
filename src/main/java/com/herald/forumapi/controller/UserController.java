package com.herald.forumapi.controller;

import com.herald.forumapi.model.User;
import com.herald.forumapi.payload.UserDAO;
import com.herald.forumapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDAO userDAO) {
        return new ResponseEntity<>(userService.register(
                userDAO.getFirstname(),
                userDAO.getLastname()),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserDAO userDAO) {
        User user = userService.login(userDAO.getFirstname(), userDAO.getLastname());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.ok().body(false);
    }
}
