package net.luvina.registration.factory;

import org.springframework.stereotype.Component;

import net.luvina.registration.dto.UserDto;
import net.luvina.registration.entity.Student;
import net.luvina.registration.entity.Teacher;
import net.luvina.registration.entity.User;
import net.luvina.registration.enums.UserType;

@Component
public class UserFactory {

  public User createUser(UserDto userDto) {
    if (UserType.STUDENT.toString().equals(userDto.getMode())) {
      return createStudent(userDto);
    } else if (UserType.TEACHER.toString().equals(userDto.getMode())) {
      return createTeacher(userDto);
    } else {
      throw new UnsupportedOperationException("Unsupported register mode");
    }
  }

  private User createStudent(UserDto userDto) {
    Student student = new Student();
    student.setName(userDto.getName());
    student.setEmail(userDto.getEmail());
    student.setPassword(userDto.getPassword());
    student.setYear(userDto.getStudent().getYear());
    return student;
  }

  private User createTeacher(UserDto userDto) {
    Teacher teacher = new Teacher();
    teacher.setName(userDto.getName());
    teacher.setEmail(userDto.getEmail());
    teacher.setPassword(userDto.getPassword());
    teacher.setPhone(userDto.getTeacher().getPhone());
    teacher.setExperiences(userDto.getTeacher().getExperiences());
    return teacher;
  }

}
