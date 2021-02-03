package net.luvina.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import net.luvina.blog.service.UserService;

@RestController
public class UserController {

  @Autowired
  private UserService userService;
  
}
