package com.herald.forumapi.service;

import com.herald.forumapi.model.Post;
import com.herald.forumapi.model.User;
import com.herald.forumapi.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    public Boolean addPost(int userId, String content) {
        Post post = new Post();
        User user = userService.getUserById(userId);
        if (user == null) {
            return false;
        }
        post.setContent(content);
        post.setUser(user);
        postRepository.save(post);
        return true;
    }
}
