package com.apress.demo4.springblog.mapper;

import com.apress.demo4.springblog.domain.Post;
import com.apress.demo4.springblog.dto.PostDto;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToPost(PostDto postInput) {
        return Post.builder()
            .title(postInput.getTitle())
            .description(postInput.getDescription())
            .body(postInput.getBody())
            .slug(postInput.getSlug())
            .postStatus(postInput.getPostStatus())
            .build();
    }

    public PostDto mapToPostDto(Post post) {
        return PostDto.builder()
            .id(post.getId())
            .title(post.getTitle())
            .description(post.getDescription())
            .body(post.getBody())
            .slug(post.getSlug())
            .postStatus(post.getPostStatus())
            .build();
    }
}
