package website.blog.repositories;

import org.springframework.stereotype.Component;
import website.blog.models.Blog;

import java.util.List;

public interface SearchRepository{
    List<Blog> searchBlogs(String keyword);
}
