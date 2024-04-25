package com.herald.forumapi.payload;

import lombok.Data;

@Data
public class CommentDTO {
    private int userId;
    private int postId;
    private String comment;
}
