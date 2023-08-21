package com.vibhusha.controller;


import com.vibhusha.client.BlogClient;
import com.vibhusha.logonservice.LogonServiceApplication;
import com.vibhusha.service.Blog;
import com.vibhusha.service.Logon;
import com.vibhusha.repository.LogonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logon")

public class LogonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogonServiceApplication.class);
    @Autowired
    private LogonRepository repository;

    @Autowired
    private BlogClient blogClient;

    @PostMapping
    public Logon addLogon(@RequestBody Logon logon) {
        LOGGER.info("Logon added");
        return repository.add(logon);

    }

    @GetMapping
    public List<Logon> getAll() {
        LOGGER.info("All the logons have gotten");
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public Logon getById(@RequestParam Long id) {
        LOGGER.info("Logon idhas gotton", id);
        return repository.getById(id);
    }

    @GetMapping("/with-blogs")
    public List<Logon> findAll() {
        List<Logon> logons = repository.getAll();
        logons.forEach(logon -> logon.setBlog(blogClient.getByUserId(logon.getUserId())));

        return logons;
    }

}
