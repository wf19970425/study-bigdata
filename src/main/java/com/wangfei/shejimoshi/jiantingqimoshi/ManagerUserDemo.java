package com.wangfei.shejimoshi.jiantingqimoshi;

public class ManagerUserDemo {
    public static void main(String[] args) throws InterruptedException {
        ManagerUserService managerUserService = new ManagerUserService();
        managerUserService.registerEventListener(e -> {
            ManagerUser user = e.getUser();
            if (ManagerUserEvent.TYPE_BEFORE_SAVE.equals(e.getType())) {
                System.out.println("监听保存前操作。。。" + user);
            } else if (ManagerUserEvent.TYPE_AFTER_SAVE.equals(e.getType())) {
                System.out.println("监听保存后操作。。。" + user);
            }
        });

        managerUserService.registerEventListener(e -> {
            ManagerUser user = e.getUser();
            if (ManagerUserEvent.TYPE_BEFORE_DELETE.equals(e.getType())) {
                System.out.println("监听删除前操作。。。" + user);
            } else if (ManagerUserEvent.TYPE_AFTER_DELETE.equals(e.getType())) {
                System.out.println("监听删除后操作。。。" + user);
            }
        });

        ManagerUser xiao_ai = new ManagerUser("xiao_ai");
        managerUserService.saveUser(xiao_ai);
        managerUserService.deleteUser(xiao_ai);
        Thread.sleep(2000);
        managerUserService.saveUser(new ManagerUser("xiao_fei"));
    }
}
