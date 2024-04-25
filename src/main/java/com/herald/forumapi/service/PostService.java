package com.herald.forumapi.service;

import com.herald.forumapi.model.Post;
import com.herald.forumapi.model.User;
import com.herald.forumapi.payload.PostResponseDTO;
import com.herald.forumapi.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PostResponseDTO> getAllPosts(int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.stream()
                .map(post -> new PostResponseDTO(post.getId(), post.getContent()))
                .toList();
    }

    public Boolean deletePost(int id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            postRepository.delete(postOptional.get());
            return true;
        }
        return false;
    }

    public Post getPost(int id) {
        return postRepository.findById(id).orElse(null);
    }
}
