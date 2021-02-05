package exception;

public class PostException extends Exception {

  private static final long serialVersionUID = 1L;

  public PostException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return "Lỗi khi thao tác với Post: " + super.getMessage();
  }
  
}
