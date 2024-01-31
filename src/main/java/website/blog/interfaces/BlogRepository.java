package website.blog.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import website.blog.models.Blog;

//@Component
public interface BlogRepository extends MongoRepository<Blog, String> {
    Blog findBlogsByName(String name);
}
