package com.consultoria.controller;

import com.consultoria.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("blog/posts")
    public Map<String, Object> getPosts() {
        return blogService.getPosts();
    }
}
