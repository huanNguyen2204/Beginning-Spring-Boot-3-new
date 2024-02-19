package com.apress.demo.springblog.domain;

import com.apress.demo.springblog.validation.BlogPostTitleAlreadyExists;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@BlogPostTitleAlreadyExists
public class Post {
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50, message = "Title must be minimum 3 characters and maximum is 50 characters")
    private String title;

    @NotNull
    @Size(min = 3, max = 500, message = "Description must be minimum 3 characters and maximum is 500 characters")
    private String description;

    @NotNull
    @Size(min = 3, max = 5000, message = "Body must be minimum 3 characters and maximum is 5000 characters")
    private String body;

    private String slug;
    private PostStatus postStatus;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<Comment> comments;
}
