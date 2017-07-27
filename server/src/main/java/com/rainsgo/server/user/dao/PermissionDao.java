package com.rainsgo.server.user.dao;

import com.rainsgo.server.user.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionDao {

    @Select("SELECT * FROM t_permissions")
    @ResultType(value = Permission.class)
    List<Permission> findAll();
}
