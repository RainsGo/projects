package com.rainsgo.server.user.dao;

import com.rainsgo.server.user.model.Permission;
import com.rainsgo.server.user.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PermissionDao {

    @Select("SELECT * FROM t_permissions")
    List<Permission> findAll();

    @Select("SELECT * FROM t_permissions WHERE name=#{name}")
    Permission findByName(@Param("name") String name);

    @Insert("INSERT INTO t_permissions(name) VALUES(#{name})")
    int addPermission(Role Role);

    @Delete("DELETE FROME t_permissions WHERE name=#{name}")
    int deletePermission(String name);
}
