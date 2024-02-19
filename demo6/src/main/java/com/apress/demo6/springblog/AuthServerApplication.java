package com.apress.demo6.springblog;

import com.apress.demo6.springblog.domain.User;
import com.apress.demo6.springblog.domain.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServerApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServerApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
            .email("admin@gmail.com")
            .userName("admin")
            .password(passwordEncoder.encode("password"))
            .role("ADMIN")
            .build();

        userRepository.save(user);
    }
}
