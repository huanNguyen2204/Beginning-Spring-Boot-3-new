package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class JdbcPostRepository {
    private final JdbcTemplate jdbcTemplate;

    public Set<Post> findAllPosts() {
        return jdbcTemplate.queryForStream(
            "select id, title, description, body, slug, post_status, created_on, updated_on from posts",
            new PostMapper
        )
    }
}
