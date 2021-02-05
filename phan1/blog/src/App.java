import entity.Comment;
import entity.Post;
import entity.User;

public class App {
  public static void main(String[] args) throws Exception {
    User user1 = new User.Builder()
      .id(1)
      .fullName("Canh")
      .build();

    Post post1 = new Post.Builder()
      .id(1)
      .title("Tile post 1")
      .content("Content post 1")
      .author(user1)
      .build();
    
    user1.writePost(post1);

    System.out.println(user1);

    for (Post post : user1.getPosts()) {
      System.out.println(post);
    }

    Post postNotExists = new Post.Builder().build();

    user1.deletePost(postNotExists);

    Comment comment1 = new Comment.Builder()
      .id(1)
      .title("Comment 1")
      .post(post1)
      .author(user1)
      .build();
  
    user1.writeComment(comment1);
  }

}
