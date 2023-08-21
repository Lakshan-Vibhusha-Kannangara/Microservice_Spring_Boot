package com.vibhusha.repository;


import com.vibhusha.service.Blog;
import com.vibhusha.service.Logon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class LogonRepository {
    private List<Logon> repository = new ArrayList<>();


    public Logon add(Logon logon) {
        repository.add(logon);
        return logon;
    }

    public List<Logon> getAll() {
        return this.repository;
    }

    public Logon getById(Long id) {
        return repository.stream().filter(item -> item.getUserId().equals(id)).findFirst().orElseThrow();
    }

    public Logon getByBlogId(Long id) {
        return repository.stream().filter(item -> item.getUserId().equals(id)).findFirst().orElseThrow();
    }


}
