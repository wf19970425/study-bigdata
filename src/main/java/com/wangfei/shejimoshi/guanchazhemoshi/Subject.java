package com.wangfei.shejimoshi.guanchazhemoshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfei
 * @create 2022-08-06 16:01
 */
public class Subject {
    private int state = 0;
    private List<Observer> list;

    public Subject() {
        this.list = new ArrayList<Observer>();
    }

    public void add(Observer observer) {
        this.list.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        for (int i = 0; i < list.size(); i++) {
            list.get(i).signal(this);
        }
    }
}
