package com.andersen.course.repository;

import com.andersen.course.model.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<NewUser,Integer> {
}
