package website.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import website.blog.interfaces.BlogRepository;
import website.blog.models.Blog;

import java.awt.*;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/blogs")
    List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    @PostMapping("/post-blog")
    Blog postBlog(@RequestBody Blog blog){
        return blogRepository.save(blog);
    }
}
