package net.luvina.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luvina.blog.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

}
