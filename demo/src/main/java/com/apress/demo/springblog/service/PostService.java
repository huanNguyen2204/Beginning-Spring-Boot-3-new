package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void addPost(Post post) {
        postRepository.addPost(post);
    }

    public Set<Post> findAllPosts() {
        return postRepository.findAllPosts();
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.findAllPosts()
            .stream()
            .anyMatch(post -> post.getTitle().equals(title));
    }

    public Post findOnePost(Integer postId) {
        return postRepository.findOnePost(postId);
    }
}
