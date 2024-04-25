package com.herald.forumapi.controller;

import com.herald.forumapi.payload.PostDTO;
import com.herald.forumapi.payload.PostResponseDTO;
import com.herald.forumapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.addPost(postDTO.getUserId(), postDTO.getContent()), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDTO>> getAll(@RequestParam int page) {
        return new ResponseEntity<>(postService.getAllPosts(page), HttpStatus.OK);
    }

}
