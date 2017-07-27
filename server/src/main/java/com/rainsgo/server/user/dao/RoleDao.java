package com.rainsgo.server.user.dao;

import com.rainsgo.server.user.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("SELECT * FROM t_roles")
    @ResultType(value = Role.class)
    List<Role> findAll();

    @Select("SELECT * FROM t_roles WHERE id=#{id}")
    @ResultType(value = Role.class)
    Role findById(@Param("id") String id);

    @Select("SELECT * FROM t_roles WHERE name=#{name}")
    @ResultType(value = Role.class)
    Role findByName(@Param("name") String name);

    @Insert("INSERT INTO t_roles(id, name, enable) VALUES(#{id}, #{name}, #{enable})")
    @ResultType(value = Role.class)
    Role addRole(Role Role);

    @Update("UPDATE t_roles SET name=#{name} WHERE id=#{id}")
    @ResultType(value = Role.class)
    Role updateRole(Role Role);

    @Delete("DELETE FROME t_roles WHERE id=#{id}")
    Long deleteRole(String id);

}
