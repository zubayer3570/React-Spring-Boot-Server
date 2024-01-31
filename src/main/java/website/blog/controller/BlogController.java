package website.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import website.blog.interfaces.BlogRepository;
import website.blog.models.Blog;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class BlogController{

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/allBlogs")
    List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    @PostMapping("/add-blog")
    Blog postBlog(@RequestBody Blog blog){
        System.out.println(blog.getName());
        return blogRepository.save(blog);
    }

    @GetMapping("/get-blog/{name}")
    Blog getBlog(@PathVariable("name") String name){
        return blogRepository.findBlogsByName(name);
    }
}
