package com.qf.dao;

import com.qf.domain.UserCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HeXiaoH
 * @date 2019/10/2 14:20
 */
public interface UserCodeRepository extends JpaRepository<UserCode,Integer> {
    UserCode findByUtel(String utel);
}
