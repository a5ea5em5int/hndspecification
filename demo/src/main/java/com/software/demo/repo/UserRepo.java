package com.software.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.software.demo.entity.User;



@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
