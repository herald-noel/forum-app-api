package com.herald.forumapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;

    private String post;

    @ManyToOne
    User user;

    @OneToMany
    List<Comment> comments;
}
