package com.rainsgo.server.user.dao;

import com.rainsgo.server.user.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by rain on 17-7-16.
 */
@Mapper
public interface UserDao {

    @Select("SELECT * FROM t_users")
    @ResultType(value = User.class)
    List<User> findAll();

    @Select("SELECT * FROM t_users WHERE id=#{id}")
    @ResultType(value = User.class)
    User findById(@Param("id") String id);

    @Select("SELECT * FROM t_users WHERE username=#{username}")
    @ResultType(value = User.class)
    User findByName(@Param("username") String username);

    @Insert("INSERT INTO t_users(username, password, age) VALUES(#{username}, #{password}, #{age})")
    @ResultType(value = User.class)
    User addUser(User user);

    @Update("UPDATE t_users SET username=#{username} WHERE id=#{id}")
    @ResultType(value = User.class)
    User updateUser(User user);

    @Delete("DELETE FROME t_users WHERE id=#{id}")
    Long deleteUser(String id);

}
