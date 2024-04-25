package com.herald.forumapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String firstname;

    private String lastname;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Post> posts;
}