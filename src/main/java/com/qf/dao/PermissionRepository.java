package com.qf.dao;


import com.qf.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HeXiaoH
 * @date 2019/10/4 9:05
 */
@Mapper
public interface PermissionRepository{
    List<Permission> selectPermissionByAdminName(@Param("aname") String aname);
}
