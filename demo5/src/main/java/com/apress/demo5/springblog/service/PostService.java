package com.apress.demo5.springblog.service;

import com.apress.demo5.springblog.domain.Post;
import com.apress.demo5.springblog.dto.PostDto;
import com.apress.demo5.springblog.mapper.PostMapper;
import com.apress.demo5.springblog.repository.PostReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostReactiveRepository postReactiveRepository;
    private final PostMapper postMapper;

    public Mono<PostDto> save(PostDto postDto) {
        Post post = postMapper.mapToPost(postDto);
        post.setCreatedOn(LocalDateTime.now());
        post.setUpdatedOn(LocalDateTime.now());
        return postReactiveRepository.save(post).map(p -> {
            postDto.setId(p.setId());
            return postDto;
        });
    }

    public Flux<PostDto> findAllPosts() {
        return postReactiveRepository.findAll()
            .map(postMapper::mapToPostDto)
            .switchIfEmpty(Flux.empty());
    }

    public Boolean postExistsWithTitle(String title) {
        return postReactiveRepository.existsById(title).block();
    }

    public Mono<PostDto> update(PostDto postDto) {
        Mono<Post> postMono = postReactiveRepository.findBySlug(slug);
        return postMono.map(postMapper::mapToPostDto);
    }
}
