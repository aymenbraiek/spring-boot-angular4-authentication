package com.biat.springbootangular4authentication.dao;

import com.biat.springbootangular4authentication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);
  //  public User findOne(Long id);
}
