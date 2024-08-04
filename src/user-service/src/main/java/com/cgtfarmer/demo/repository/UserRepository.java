package com.cgtfarmer.demo.repository;

import com.cgtfarmer.demo.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  public List<User> findAll();

  public User findById(int id);
}
