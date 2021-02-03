package net.luvina.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.luvina.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  public List<Comment> findByPostId(long postId);

}
