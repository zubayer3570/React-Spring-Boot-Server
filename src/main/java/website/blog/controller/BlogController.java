package website.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import website.blog.repositories.BlogRepository;
import website.blog.entities.Blog;
import website.blog.repositories.SearchRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@CrossOrigin("*")
public class BlogController{

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/allBlogs")
    List<Blog> getAllBlogs(){
        List<Blog> allblogs = blogRepository.findAll();
//        allblogs.sort(Comparator.comparingInt(b-> Integer.parseInt(String.join("", b.getDate().split("-")))));
        return allblogs.reversed();
//        return allblogs;
    }

    @PostMapping("/add-blog")
    Blog postBlog(@RequestBody Blog blog){
        blog.setDate(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        return blogRepository.save(blog);
    }

    @GetMapping("/get-blog/{name}")
    Blog getBlog(@PathVariable("name") String name){
        System.out.println(name);
        return blogRepository.findBlogsByName(name);
    }

    @GetMapping("/search/{keyword}")
    List<Blog> searchBlogs(@PathVariable String keyword){
        System.out.println(keyword);
        return searchRepository.searchBlogs(keyword);
    }

    @DeleteMapping("/delete-blog")
    void deleteBlog(@RequestBody String id){
        blogRepository.deleteById(id);
    }

    @PutMapping("/update-blog")
    Blog updateBlog(@RequestBody Blog blog){
        return blogRepository.save(blog);
    }
}
