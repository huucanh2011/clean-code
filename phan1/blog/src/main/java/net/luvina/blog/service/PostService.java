package net.luvina.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luvina.blog.entity.Post;
import net.luvina.blog.repository.PostRepository;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public void addPost(Post post) {
    postRepository.save(post);
  }
}
