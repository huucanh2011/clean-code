package entity;

public class Comment {
  
  private long id;

  private String title;

  private Post post;

  private User author;

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

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  private Comment() {
  }

  public static class Builder {

    private long id;

    private String title;

    private Post post;

    private User author;

    public Builder id(long id) {
      this.id = id;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder post(Post post) {
      this.post = post;
      return this;
    }

    public Builder author(User author) {
      this.author = author;
      return this;
    }

    public Comment build() {
      Comment comment = new Comment();
      comment.id = this.id;
      comment.title = this.title;
      comment.post = this.post;
      comment.author = this.author;
      return comment;
    }
  }
}
