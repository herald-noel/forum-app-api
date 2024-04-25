package com.herald.forumapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private int id;

    private String comment;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "post_id")
    Post post;
}