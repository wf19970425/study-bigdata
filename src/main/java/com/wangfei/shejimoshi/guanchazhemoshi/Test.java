package com.wangfei.shejimoshi.guanchazhemoshi;

/**
 * @author wangfei
 * @create 2022-08-06 16:09
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.add(new CompactionObserver());
        subject.add(new ClusterObserver());
        subject.add(new CleanObserver());
        subject.setState(5);
        subject.setState(15);
        subject.setState(25);
        subject.setState(6);
        subject.setState(16);
        subject.setState(26);
        subject.setState(26);
        subject.setState(26);
        subject.setState(26);
        subject.setState(26);

    }
}
