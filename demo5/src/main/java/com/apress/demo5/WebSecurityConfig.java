package com.apress.demo5;

import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class WebSecurityConfig {
    private final DataSource dataSource;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity)
}
