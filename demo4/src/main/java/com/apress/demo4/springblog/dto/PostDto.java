package com.apress.demo4.springblog.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Title must be minimum 3 characters, and maximum 50 characters long")
    private String title;

    @NotNull
    @Size(min = 3, max = 50, message = "Description must be minimum 3 characters, and maximum 50 characters long")
    private String description;

    @NotNull
    @Size(min = 3, max = 5000, message = "Body must be minimum 3 characters, and maximum 5000 characters long")
    private String body;

    private String slug;
    private PostStatus postStatus;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
