package com.java.demo3.dao;

import org.springframework.data.repository.CrudRepository;
import com.java.demo3.entities.User;

public interface UserRepository extends CrudRepository <User,Integer> {
}
