package com.herald.forumapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;

    private String lastname;

    @OneToMany
    List<Comment> comments;

    @OneToMany
    List<Post> posts;
}