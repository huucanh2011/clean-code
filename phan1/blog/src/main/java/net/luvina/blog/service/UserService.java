package net.luvina.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luvina.blog.entity.Post;
import net.luvina.blog.repository.PostRepository;
import net.luvina.blog.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  public Post writePost(Post post) {
    post = new Post(post.getTitle(), post.getContent(), post.getUser());
    postService.addPost(post);
    return post;
  }

  public boolean deletePost(long id) {
    Optional<Post> idPost = postRepository.findById(id);
    if (idPost != null) {
      postRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }
}
