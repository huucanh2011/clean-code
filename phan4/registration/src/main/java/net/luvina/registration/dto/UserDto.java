package net.luvina.registration.dto;

import lombok.Data;

@Data
public class UserDto {

  private String name;

  private String email;

  private String password;

  private StudentDto student;

  private TeacherDto teacher;

  private String mode;
}
