package com.wangfei.shejimoshi.guanchazhemoshi;

/**
 * @author wangfei
 * @create 2022-08-06 16:14
 */
public class CompactionObserver extends Observer{

    @Override
    public void signal(Subject subject) {
        int state = subject.getState();
        if (state >= 0 && state < 10) {
            System.out.println("compaction saw the state is: " + state);
        }
    }
}
