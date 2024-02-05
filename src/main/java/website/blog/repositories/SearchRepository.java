package website.blog.repositories;

import website.blog.entities.Blog;

import java.util.List;

public interface SearchRepository{
    List<Blog> searchBlogs(String keyword);
}
