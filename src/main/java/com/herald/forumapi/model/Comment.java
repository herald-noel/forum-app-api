package com.herald.forumapi.model;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;

    private String comment;

    @ManyToOne
    User user;

    @ManyToOne
    Post post;
}