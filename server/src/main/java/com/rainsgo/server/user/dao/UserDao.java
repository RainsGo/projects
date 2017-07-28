package com.rainsgo.server.user.dao;

import com.rainsgo.server.user.model.Role;
import com.rainsgo.server.user.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by rain on 17-7-16.
 */
@Mapper
public interface UserDao {

    @Select("SELECT * FROM t_users")
    @ResultType(User.class)
    List<User> findAll();

    @Select("SELECT * FROM t_users WHERE id=#{id}")
    @ResultType(User.class)
    User findById(@Param("id") String id);

    @Select("SELECT * FROM t_users WHERE username=#{username}")
    @ResultType(User.class)
    User findByName(@Param("username") String username);

    @Insert("INSERT INTO t_users(id, username, password, age, email, last_password_reset_date) "
            + "VALUES(#{id}, #{username}, #{password}, #{age}, #{email}, #{lastPasswordResetDate})")
    int addUser(User user);

    @Update("UPDATE t_users SET username=#{username} WHERE id=#{id}")
    int updateUser(User user);

    @Delete("DELETE FROME t_users WHERE id=#{id}")
    int deleteUser(String id);
}
