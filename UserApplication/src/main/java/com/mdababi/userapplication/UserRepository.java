package com.mdababi.userapplication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    List<User> findByCourseId(BigInteger courseId);
}
