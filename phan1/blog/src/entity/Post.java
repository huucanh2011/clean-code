package entity;

import java.util.ArrayList;

public class Post {
  
  private long id;

  private String title;

  private String content;

  private User author;
  
  private ArrayList<Comment> comments;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public ArrayList<Comment> getComments() {
    return comments;
  }

  public void setComments(ArrayList<Comment> comments) {
    this.comments = comments;
  }

  private Post() {
  }

  @Override
  public String toString() {
    return "{Post: id=" + this.id + ", title=" + this.title + ", content=" + this.content + ", author=" + this.author.getFullName() + "}";
  }

  public static class Builder {

    private long id;

    private String title;

    private String content;

    private User author;
    
    private ArrayList<Comment> comments;

    public Builder id(long id) {
      this.id = id;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder content(String content) {
      this.content = content;
      return this;
    }

    public Builder author(User author) {
      this.author = author;
      return this;
    }

    public Builder comments(ArrayList<Comment> comments) {
      this.comments = comments;
      return this;
    }

    public Post build() {
      Post post = new Post();
      post.id = this.id;
      post.title = this.title;
      post.content = this.content;
      post.author = this.author;
      post.comments = this.comments;
      return post;
    }

  }
}
