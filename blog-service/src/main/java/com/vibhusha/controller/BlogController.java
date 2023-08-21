package com.vibhusha.controller;


import com.vibhusha.blogservice.BlogServiceApplication;
import com.vibhusha.model.Blog;
import com.vibhusha.repository.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {


    @Autowired

    private BlogRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogServiceApplication.class);

    @PostMapping
    public Blog addPost(@RequestBody Blog blog) {
        LOGGER.info("post added");
        return repository.add(blog);
    }

    @GetMapping
    public List<Blog> getAll() {

        LOGGER.info("all the posts have added");
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public Blog getById(@RequestParam Long id) {

        LOGGER.info("post added of id :", id);
        return repository.getById(id);
    }

    @GetMapping("/login/{id}")
    public Blog getByUserId(@RequestParam Long id) {

        LOGGER.info("post added of id :", id);
        return repository.getByUserId(id);
    }
}
