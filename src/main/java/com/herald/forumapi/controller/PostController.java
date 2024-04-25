package com.herald.forumapi.controller;

import com.herald.forumapi.payload.PostDAO;
import com.herald.forumapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody PostDAO postDAO) {
        return new ResponseEntity<>(postService.addPost(postDAO.getUserId(), postDAO.getContent()), HttpStatus.OK);
    }

}
