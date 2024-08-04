package com.cgtfarmer.demo.controller;

import com.cgtfarmer.demo.entity.User;
import com.cgtfarmer.demo.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> index() {
    log.info("[UserController#index]");

    List<User> response = this.userService.findAll();

    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<User> create(@RequestBody User request) {
    log.info("[UserController#create] request={}", request);

    User response = this.userService.create(request);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> show(@PathVariable Integer id) {
    log.info("[UserController#show] id={}", id);

    User response = this.userService.findById(id);

    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(
    @PathVariable Integer id,
    @RequestBody User request
  ) {
    log.info("[UserController#update] id={}, request={}", id, request);

    request.setId(id);

    User response = this.userService.update(request);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> destroy(@PathVariable Integer id) {
    log.info("[UserController#destroy] id={}", id);

    this.userService.destroy(id);

    return ResponseEntity.ok("{ \"msg\": \"ID: " + id + " deleted successfully\" }");
  }
}
