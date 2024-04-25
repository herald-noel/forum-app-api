package com.herald.forumapi.controller;

import com.herald.forumapi.payload.CommentDTO;
import com.herald.forumapi.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/reply")
    public Boolean reply(@RequestBody CommentDTO commentDTO) {
        return commentService.addComment(commentDTO.getUserId(), commentDTO.getPostId(), commentDTO.getComment());
    }
}
