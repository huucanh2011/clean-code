package net.luvina.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.luvina.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
