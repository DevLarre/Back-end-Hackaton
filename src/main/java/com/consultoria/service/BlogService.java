package com.consultoria.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class BlogService {

    @Value("${blogger.api.key}")
    private String apiKey;

    @Value("${blogger.blog.id}")
    private String blogId;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getPosts() {
        String url = "https://www.googleapis.com/blogger/v3/blogs/" + blogId + "/posts?key=" + apiKey;
        return restTemplate.getForObject(url, Map.class);
    }
}
