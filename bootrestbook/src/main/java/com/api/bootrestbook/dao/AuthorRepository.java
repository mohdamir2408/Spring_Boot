package com.api.bootrestbook.dao;

import com.api.bootrestbook.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
