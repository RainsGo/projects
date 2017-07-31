package com.rainsgo.server.auth.api;

import com.rainsgo.server.api.ApiException;

/**
 * Created by Rain on 17-8-1.
 */
public class AuthException extends ApiException {
    public AuthException(String info){
        super(1000L, info, null);
    }
}
