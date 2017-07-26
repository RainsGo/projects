package com.rainsgo.server.log.dao;

import com.rainsgo.server.log.model.LoginLog;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by rain on 17-7-16.
 */
@Mapper
public interface LoginLogDao {

    @Select("SELECT * FROM t_loginlog")
    List<LoginLog> findAllLogs();

    @Select("SELECT * FROME t_user WHERE user_id=#(userId)")
    LoginLog findByUserId(@Param("userId") Long userId);

    @Insert("")
    Long addLog(LoginLog log);
}
