package com.rainsgo.server.user.dao;

import com.rainsgo.server.user.model.Permission;
import com.rainsgo.server.user.model.Role;
import com.rainsgo.server.user.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("select * from t_roles")
    @ResultType(Role.class)
    List<Role> findAll();

    @Select("SELECT * FROM t_roles WHERE name=#{name}")
    @ResultType(Role.class)
    Role findByName(@Param("name") String name);

    @Insert("INSERT INTO t_roles(name, enable) VALUES(#{name}, #{enable})")
    int addRole(Role Role);

    @Update("UPDATE t_roles SET enable=#{enable} WHERE name=#{name}")
    int updateRole(Role Role);

    @Delete("DELETE FROME t_roles WHERE name=#{name}")
    int deleteRole(String name);

    @Select("SELECT * FROM t_user_role WHERE user_id=#{id}")
    @Results({
            @Result(property = "name", column = "name",id = true),
            @Result(property = "enable", column = "enable"),
            @Result(property = "roles", javaType = List.class, column = "name",
                many = @Many(select = "com.rainsgo.server.dao.RoleDao.findByName"))
    })
    List<Role> findByUserId(@Param("id") String userId);
}
