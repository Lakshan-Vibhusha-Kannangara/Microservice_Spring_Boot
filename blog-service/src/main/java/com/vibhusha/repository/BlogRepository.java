package com.vibhusha.repository;


import com.vibhusha.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {

    private List<Blog> repository = new ArrayList<>();

    public Blog add(Blog blog) {
        repository.add(blog);
        return blog;
    }

    public List<Blog> getAll() {
        return repository;
    }

    public Blog getById(Long id) {
        return repository.stream().filter(item -> item.getId().equals(id)).findFirst().orElseThrow();
    }

    public Blog getByUserId(Long id) {
        return repository.stream().filter(item -> item.getUserId().equals(id)).findFirst().orElseThrow();

    }
}
