package com.wangfei.shejimoshi.jiantingqimoshi;

import java.util.ArrayList;
import java.util.List;

public class ManagerUserService {
    private final List<ManagerUserListener> listeners = new ArrayList<>();

    public void registerEventListener(ManagerUserListener listener) {
        listeners.add(listener);
    }

    public ManagerUser saveUser(ManagerUser user) {
        toListen(ManagerUserEvent.TYPE_BEFORE_SAVE, user);
        System.out.println(String.format("保存用户： %s", user));
        user.setId("001");
        toListen(ManagerUserEvent.TYPE_AFTER_SAVE, user);
        return user;
    }

    public void deleteUser(ManagerUser user) {
        toListen(ManagerUserEvent.TYPE_BEFORE_DELETE, user);
        System.out.println(String.format("删除用户： %s", user));
        toListen(ManagerUserEvent.TYPE_AFTER_DELETE, user);
    }

    private void toListen(String type, ManagerUser user) {
        toAction(new ManagerUserEvent(this, type, user));
    }

    private void toAction(ManagerUserEvent event) {
        if (listeners == null || listeners.isEmpty()) {
            return;
        }
        for (ManagerUserListener listener : listeners) {
            new Thread(() -> {
                listener.action(event);
            }).start();
        }
    }
}
