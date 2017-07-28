package com.rainsgo.server.auth.service;

import com.rainsgo.server.user.model.User;

public interface AuthService {
    boolean register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
