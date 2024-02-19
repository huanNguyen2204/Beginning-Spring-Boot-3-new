package com.apress.demo.springblog.controller;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.exception.SpringBlogException;
import com.apress.demo.springblog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String postPage(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        return "post";

//        Post post = new Post();
//        post.setTitle("Hello Spring Boot");
//        post.setDescription("Spring Boot");
//        post.setBody("Spring Boot is Awesome");
//
//        Post post1 = new Post();
//        post1.setTitle("Hello Spring Boot 3");
//        post1.setDescription("Spring Boot 3");
//        post1.setBody("Spring Boot 3 is Awesome");
//
//        model.addAttribute("posts", Arrays.asList(post, post1));
//        return "post";
    }

    @GetMapping("/add")
    public String addPostPage(Model model) {
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return "addPost";
        }
        postService.addPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String onePostPage(Model model, @PathVariable Integer id) {
        model.addAttribute("posts", postService.findOnePost(id));
        return "onePost";
    }

    @ExceptionHandler(SpringBlogException.class)
    public ModelAndView handleSpringBlogException(SpringBlogException ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("exception", ex);
        return model;
    }
}
