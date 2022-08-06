package com.wangfei.shejimoshi.jiantingqimoshi;

import lombok.Data;

@Data
public class ManagerUser {

    private String id;
    private String name;

    public ManagerUser(String name) {
        this.name = name;
    }
}
