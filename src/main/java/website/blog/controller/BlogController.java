package website.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import website.blog.interfaces.BlogRepository;
import website.blog.models.Blog;
import java.util.List;

@RestController
@CrossOrigin("*")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/allBlogs")
    List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    @PostMapping("/post-blog")
    Blog postBlog(@RequestBody Blog blog){
        return blogRepository.save(blog);
    }
}
