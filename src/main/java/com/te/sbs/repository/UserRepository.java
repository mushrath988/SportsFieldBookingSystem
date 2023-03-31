package com.te.sbs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

 public Optional<User> findByEmail(String email);

	

}