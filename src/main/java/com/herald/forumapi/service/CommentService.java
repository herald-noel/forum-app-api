package com.herald.forumapi.service;

import com.herald.forumapi.model.Comment;
import com.herald.forumapi.model.Post;
import com.herald.forumapi.model.User;
import com.herald.forumapi.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public Boolean addComment(int userId, int postId, String comment) {
        // Check if User and Post exist
        User user = userService.getUserById(userId);
        Post post = postService.getPost(postId);
        if (user == null || post == null) {
            return false;
        }
        Comment newComment = new Comment();
        newComment.setUser(user);
        newComment.setPost(post);
        newComment.setComment(comment);
        commentRepository.save(newComment);
        return true;
    }

    public Boolean deleteComment(int id) {
        // Check if comment exist
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
