package com.apress.demo4.springblog.controller;

import com.apress.demo4.springblog.domain.Post;
import com.apress.demo4.springblog.dto.PostDto;
import com.apress.demo4.springblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @CrossOrigin
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> listPosts() {
        return postService.findAllPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.save(postDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PostDto updatePost(@RequestBody PostDto postDto) {
        return postService.update(postDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }

    @GetMapping("/{slug}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto findPostBySlug(@PathVariable String slug) {
        return postService.findBySlug(slug);
    }
}
