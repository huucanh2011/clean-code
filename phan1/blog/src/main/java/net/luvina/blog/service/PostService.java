package net.luvina.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luvina.blog.dto.PostDto;
import net.luvina.blog.entity.Post;
import net.luvina.blog.repository.PostRepository;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<PostDto> getAllPost() {
    List<Post> posts = postRepository.findAll();
    return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
  }

  public PostDto getPostById(long id) {
    Optional<Post> post = postRepository.findById(id);
    return modelMapper.map(post, PostDto.class);
  }

  public PostDto addPost(PostDto postDto) {
    Post post = new Post();
    modelMapper.map(postDto, post);
    Post savedPost = postRepository.save(post);
    return modelMapper.map(savedPost, PostDto.class);
  }

  public boolean deletePost(long id) {
    Optional<Post> post = postRepository.findById(id);
    if (post.isPresent()) {
      postRepository.deleteById(id);
      return true;
    }
    return false;
  }

}
