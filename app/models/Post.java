package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post extends Model {
    public String title;
    public Date postedAt;
    
    @Lob
    public String content;
    
    @ManyToOne
    public User author;
    
    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    public List<Comment> comments;
    
    public Post(User author, String title, String content) {
    	this.comments = new ArrayList<Comment>();
    	this.author = author;
    	this.title = title;
    	this.content = content;
    	this.postedAt = new Date();
    }
    
    public Post addComment(String author, String content) {
    	//Comment newComment = new Comment(this, author, content).save();
    	//this.comments.add(newComment);
    	//TODO: Combine above 2 lines into single statement
    	this.comments.add(new Comment(this, author, content).save()); //A bit messy?
    	
    	this.save();
    	return this;
    }
}