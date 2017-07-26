package com.rainsgo.server.user.auth;

import com.rainsgo.server.user.model.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
