package com.qf.dao;

import com.qf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserManageMapper extends JpaRepository<User,Integer> {


    User findByUname(String username);
}
