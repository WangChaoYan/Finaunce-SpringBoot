package com.qf.dao;

import com.qf.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HeXiaoH
 * @date 2019/10/4 8:58
 */
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByAname(String aname);
}
