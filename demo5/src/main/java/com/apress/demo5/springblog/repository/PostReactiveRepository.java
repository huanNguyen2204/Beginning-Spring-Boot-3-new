package com.apress.demo5.springblog.repository;

import com.apress.demo5.springblog.domain.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public class PostReactiveRepository extends ReactiveCrudRepository<Post, String> {

}
