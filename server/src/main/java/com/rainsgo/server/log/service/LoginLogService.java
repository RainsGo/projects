package com.rainsgo.server.log.service;

import com.rainsgo.server.log.model.LoginLog;

import java.util.List;

public interface LoginLogService {

    List<LoginLog> findAllLogs();

    LoginLog findLogByUserId(Long userId);

    Long saveLog(LoginLog log);
}
