package website.blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import website.blog.entities.Blog;

public interface BlogRepository extends MongoRepository<Blog, String> {
    Blog findBlogsByName(String name);
}
