package exception;

public class CommentException extends Exception {

  private static final long serialVersionUID = 1L;

  public CommentException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return "Lỗi khi thao tác với Comment: " + super.getMessage();
  }
  
}
