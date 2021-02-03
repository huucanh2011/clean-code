package net.luvina.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.luvina.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

  @Override
  default <S extends Post> S save(S entity) {
    return null;
  }
}
