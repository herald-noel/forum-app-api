package com.herald.forumapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue
    private int id;

    private String content;

    @ManyToOne
    User user;

    @OneToMany
    List<Comment> comments;
}
