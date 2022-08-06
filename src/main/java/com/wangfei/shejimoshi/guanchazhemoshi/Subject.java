package com.wangfei.shejimoshi.guanchazhemoshi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangfei
 * @create 2022-08-06 16:01
 */
public class Subject {
    private int state = 0;
    private List<Observer> list;
    private ExecutorService pool;

    public Subject() {
        this.list = new ArrayList<Observer>();
        pool = Executors.newFixedThreadPool(5);
    }

    public Subject(int state) {
        this.state = state;
    }

    public void add(Observer observer) {
        this.list.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        Subject subject = new Subject(state);
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).signal(subject);
//        }
        for (Observer observer : list) {
//            new Thread(() -> {
//                observer.signal(this);
//            }).start();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    observer.signal(subject);
                }
            });
        }
    }
}
