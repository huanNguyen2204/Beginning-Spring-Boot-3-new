package com.apress.demo3.springblog.repository;

import com.apress.demo3.springblog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Comment, Integer> {
}
