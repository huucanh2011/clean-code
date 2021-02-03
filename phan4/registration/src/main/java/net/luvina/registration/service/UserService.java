package net.luvina.registration.service;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.luvina.registration.dto.UserDto;
import net.luvina.registration.dto.UserResDto;
import net.luvina.registration.entity.User;
import net.luvina.registration.error.ErrorCodes;
import net.luvina.registration.error.ServiceRuntimeException;
import net.luvina.registration.factory.UserFactory;
import net.luvina.registration.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final UserFactory userFactory;

  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email).orElse(null);
  }

  @Transactional
  public UserResDto createUser(UserDto userDto) throws RuntimeException {
    if (findUserByEmail(userDto.getEmail()) == null) {
      User user = userFactory.createUser(userDto);
      User createdUser = userRepository.save(user);
      UserResDto userResDto = new UserResDto();
      userResDto.setName(createdUser.getName());
      userResDto.setEmail(createdUser.getEmail());
      return userResDto;
    } else {
      throw new ServiceRuntimeException(HttpStatus.BAD_REQUEST, ErrorCodes.USER_ER001, "Email has already been taken");
    }
  }
}
