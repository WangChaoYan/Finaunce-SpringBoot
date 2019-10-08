package com.qf.dao;

import com.qf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUtel(String utel);
    User findByUname(String uname);
}
