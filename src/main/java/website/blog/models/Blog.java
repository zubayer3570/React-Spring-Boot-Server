package website.blog.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "blogs")
public class Blog {

    @Id
    private String _id;
    private String author;
    private String name;
    private String text;

    public Blog(String _id, String author, String name, String text) {
        this._id = _id;
        this.author = author;
        this.name = name;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String  get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
