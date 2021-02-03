package net.luvina.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.luvina.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
