package net.luvina.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.luvina.blog.dto.PostDto;
import net.luvina.blog.service.PostService;

@RestController
public class PostController {
  
  @Autowired
  private PostService postService;

  @GetMapping("/posts")
  public ResponseEntity<List<PostDto>> getAllPost() {
    List<PostDto> posts = postService.getAllPost();
    return new ResponseEntity<>(posts, HttpStatus.OK);
  }

  @PostMapping("/posts")
  public ResponseEntity<PostDto> createPost(@RequestBody PostDto postReqDto) {
    PostDto createdPost = postService.addPost(postReqDto);
    return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
  }

  @DeleteMapping("/posts/{post_id}")
  public ResponseEntity<PostDto> deletePost(@PathVariable("post_id") long id) {
    boolean isDeleted = postService.deletePost(id);
    if (!isDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
