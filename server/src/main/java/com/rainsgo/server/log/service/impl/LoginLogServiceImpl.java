package com.rainsgo.server.log.service.impl;

import com.rainsgo.server.log.dao.LoginLogDao;
import com.rainsgo.server.log.model.LoginLog;
import com.rainsgo.server.log.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public List<LoginLog> findAllLogs() {
        return loginLogDao.findAllLogs();
    }

    @Override
    public LoginLog findLogByUserId(Long userId) {
        return loginLogDao.findByUserId(userId);
    }

    @Override
    public Long saveLog(LoginLog log) {
        return loginLogDao.addLog(log);
    }
}
