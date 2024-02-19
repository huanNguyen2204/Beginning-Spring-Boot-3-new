package com.apress.demo5.springblog.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private Long id;
    private String title;
    private String authorName;
    private String body;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Post post;
}
