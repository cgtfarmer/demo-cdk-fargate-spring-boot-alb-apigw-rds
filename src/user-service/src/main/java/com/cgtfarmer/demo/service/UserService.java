package com.cgtfarmer.demo.service;

import com.cgtfarmer.demo.entity.User;
import com.cgtfarmer.demo.repository.UserRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAll() {
    log.info("[UserService#findAll]");

    return this.userRepository.findAll();
  }

  public User findById(int id) {
    log.info("[UserService#findById] id={}", id);

    return this.userRepository.findById(id);
  }

  public User create(User user) {
    log.info("[UserService#create] user={}", user);

    return this.userRepository.save(user);
  }

  public User update(User user) {
    log.info("[UserService#update] user={}", user);

    return this.userRepository.save(user);
  }

  public void destroy(int id) {
    log.info("[UserService#destroy] id={}", id);

    User user = new User();
    user.setId(id);

    this.userRepository.delete(user);
  }
}
