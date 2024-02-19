package com.apress.demo6.springblog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<User, Long> {
}
