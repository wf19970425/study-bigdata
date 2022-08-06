package com.wangfei.shejimoshi.guanchazhemoshi;

/**
 * @author wangfei
 * @create 2022-08-06 16:14
 */
public class CleanObserver extends Observer{

    @Override
    public void signal(Subject subject) {
        int state = subject.getState();
        if (state >= 20 && state < 30) {
            System.out.println("cluster saw the state is: " + state);
        }
    }
}
