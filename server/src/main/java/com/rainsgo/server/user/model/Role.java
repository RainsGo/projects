package com.rainsgo.server.user.model;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    private String name;

    private Boolean enable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
