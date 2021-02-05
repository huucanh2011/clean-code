package entity;

import java.util.ArrayList;

import exception.CommentException;
import exception.PostException;

public class User {

  private long id;

  private String fullName;

  private ArrayList<Post> posts = new ArrayList<>();

  private ArrayList<Comment> comments = new ArrayList<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public ArrayList<Post> getPosts() {
    return posts;
  }

  public void setPosts(ArrayList<Post> posts) {
    this.posts = posts;
  }

  public ArrayList<Comment> getComments() {
    return comments;
  }

  public void setComments(ArrayList<Comment> comments) {
    this.comments = comments;
  }

  private User() {
  }

  @Override
  public String toString() {
    return "{User: id=" + this.id + ", fullName=" + this.fullName + ", postCount=" + this.posts.size() + "}";
  }

  public static class Builder {
    private long id;

    private String fullName;

    private ArrayList<Post> posts;

    private ArrayList<Comment> comments;

    public Builder id(long id) {
      this.id = id;
      return this;
    }

    public Builder fullName(String fullName) {
      this.fullName = fullName;
      return this;
    }

    public Builder posts(ArrayList<Post> posts) {
      this.posts = posts;
      return this;
    }

    public Builder comments(ArrayList<Comment> comments) {
      this.comments = comments;
      return this;
    }

    public User build() {
      User user = new User();
      user.id = this.id;
      user.fullName = this.fullName;
      user.posts = this.posts;
      user.comments = this.comments;
      return user;
    }
  }

  public void writePost(Post post) {
    this.posts.add(post);
  }

  public void deletePost(Post post) throws PostException {
    if (this.posts.size() == 0) {
      throw new PostException("Không có post nào");
    }
    if (!this.posts.contains(post)) {
      throw new PostException("Không tồn tại post");
    }
    this.posts.remove(post);
  }

  public void writeComment(Comment comment) {
    this.comments.add(comment);
  }

  public void deleteComment(Comment comment) throws CommentException {
    if (this.comments.size() == 0) {
      throw new CommentException("Không có comment nào");
    }
    if (!this.comments.contains(comment)) {
      throw new CommentException("Không tồn tại comment");
    }
    if (this.id != comment.getAuthor().id) {
      throw new CommentException("Bạn không thể xóa comment của người khác");
    }
    this.comments.remove(comment);
  }

}
