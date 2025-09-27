package com.postgres.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class MyController {

    @GetMapping
    public String getData()
    {
        log.info("called method v3");
        return "hello";
    }
}
