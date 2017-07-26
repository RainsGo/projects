package com.rainsgo.server.log.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rain on 17-7-16.
 */
@Data
public class LoginLog implements Serializable {

    /**
     * 日志ID
     */
    private Long id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 登录时间
     */
    private Timestamp loginDate;
}
