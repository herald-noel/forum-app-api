package com.herald.forumapi.payload;

import lombok.Data;
import lombok.Getter;

@Data
public class PostDTO {
    private int userId;
    private String content;
}
