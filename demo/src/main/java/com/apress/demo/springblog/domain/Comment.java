package com.apress.demo.springblog.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50, message = "Title must be minimum 3 and maximum 50 characters long")
    private String title;

    @NotNull
    private String authorName;

    @NotNull
    @Size(min = 3, max = 100, message = "Body must be minimum 3 and maximum 100 characters long")
    private String body;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
