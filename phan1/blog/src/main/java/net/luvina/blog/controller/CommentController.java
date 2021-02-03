package net.luvina.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.luvina.blog.dto.CommentDto;
import net.luvina.blog.service.CommentService;

@RestController
public class CommentController {

  @Autowired
  private CommentService commentService;

  @GetMapping("/posts/{post_id}/comments")
  public ResponseEntity<List<CommentDto>> getAllComment(@PathVariable("post_id") long postId) {
    List<CommentDto> commentsDtos = commentService.getAllCommentByPostId(postId);
    return new ResponseEntity<>(commentsDtos, HttpStatus.OK);
  }

  @PostMapping("/posts/{post_id}/comments")
  public ResponseEntity<CommentDto> createComment(@PathVariable("post_id") long postId,
      @RequestBody CommentDto commentDto) {
    return null;
  }
}
