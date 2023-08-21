package com.vibhusha.client;

import com.vibhusha.service.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface BlogClient {
    @GetExchange("blog/login/{id}")
    public Blog getByUserId(@RequestParam Long id);
}