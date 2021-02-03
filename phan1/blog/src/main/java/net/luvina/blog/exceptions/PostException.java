package net.luvina.blog.exceptions;

public class PostException extends Exception {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public PostException(String errorMessage) {
    super(errorMessage);
  }
}
