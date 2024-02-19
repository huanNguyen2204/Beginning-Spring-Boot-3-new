package com.apress.demo4.springblog.service;

import com.apress.demo4.springblog.domain.Post;
import com.apress.demo4.springblog.dto.PostDto;
import com.apress.demo4.springblog.mapper.PostMapper;
import com.apress.demo4.springblog.repository.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostDto save(PostDto postDto) {
        Post post = postMapper.mapToPost(postDto);
        Post savedPost = postRepository.save(postDto);
        postDto.setId(savedPost.getId());
        return postDto;
    }

    public List<PostDto> findAllPosts() {
        return postRepository.findAll()
            .stream()
            .map(postMapper::mapToPostDto).toList();
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.existsByTitle(title);
    }

    public PostDto update(PostDto postDto) {
        Post post = postRepository.findById(postDto.getId())
            .orElseThrow(() -> new SpringBlogException("Cannot find Post with Id " + postDto.getId()));
        Post savedPost = postMapper.mapToPost(postDto);
        savedPost.setId(post.getId());
        postRepository.save(savedPost);
        return postDto;
    }

    public PostDto findBySlug(String slug) {
        Post post = postRepository.findBySlug(slug)
            .orElseThrow(() -> new SpringBlogException("Cannot find Post with Slug " + slug));
        return postMapper.mapToPostDto(post);
    }
}
