package website.blog.implementations;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import website.blog.models.Blog;
import website.blog.repositories.BlogRepository;
import website.blog.repositories.SearchRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import java.util.concurrent.TimeUnit;

import org.bson.Document;
import com.mongodb.client.AggregateIterable;

@Component
public class SearchImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> searchBlogs(String keyword) {
        if(keyword.equals("all")){
            System.out.println("hello");
            return blogRepository.findAll();
        }

        List<Blog> arrayList = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("spring_boot_blog");
        MongoCollection<Document> collection = database.getCollection("blogs");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "search_index_1")
                                .append("text",
                                        new Document("query", "Blog-1")
                                                .append("path", Arrays.asList("name", "text", "author")))),
                new Document("$limit", 5L)));

        result.forEach(document -> arrayList.add(mongoConverter.read(Blog.class, document)));
        return arrayList;
    }
}
