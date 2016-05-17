package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;


@Entity
public class Comment extends Model {
    @Required
    public String author;

    @Required
    public Date postedAt;
    
    @Lob
    @Required
    @MaxSize(10000)
    public String content;
    
    @ManyToOne
    @Required
    public Post post;
    
    public Comment(Post post, String author, String content) {
    	this.post = post;
    	this.author = author;
    	this.content = content;
    	this.postedAt = new Date();
    }

    //toStrting is used by the CRUD module in the default template
    public String toString() {
        return postedAt + " by " +author + " on " + post;
    }
}
