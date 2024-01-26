package website.blog.interfaces;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import website.blog.models.Blog;

public interface BlogRepository extends MongoRepository<Blog, String> {
}
