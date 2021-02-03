package net.luvina.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luvina.blog.dto.CommentDto;
import net.luvina.blog.entity.Comment;
import net.luvina.blog.entity.Post;
import net.luvina.blog.repository.CommentRepository;
import net.luvina.blog.repository.PostRepository;

@Service
public class CommentService {

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<CommentDto> getAllCommentByPostId(long postId) {
    List<Comment> comments = commentRepository.findByPostId(postId);
    return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
  }

  public CommentDto addComment(long postId, CommentDto commentDto) {
    Optional<Post> post = postRepository.findById(postId);

    if (post.isPresent()) {
      // commentDto.set
    }

    Comment comment = new Comment();
    modelMapper.map(commentDto, comment);
    Comment savedComment = commentRepository.save(comment);
    return modelMapper.map(savedComment, CommentDto.class);
  }

  
}
