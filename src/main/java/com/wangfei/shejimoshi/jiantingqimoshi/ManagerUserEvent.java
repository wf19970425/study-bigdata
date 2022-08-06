package com.wangfei.shejimoshi.jiantingqimoshi;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ManagerUserEvent extends EventObject  {
    private static final long serialVersionUID = 5516075349620653480L;

    public static String TYPE_BEFORE_SAVE = "before_save";
    public static String TYPE_AFTER_SAVE = "after_save";
    public static String TYPE_BEFORE_DELETE = "before_delete";
    public static String TYPE_AFTER_DELETE = "after_delete";

    private String type;
    private ManagerUser user;

    public ManagerUserEvent(Object source) {
        super(source);
    }

    public ManagerUserEvent(Object source, String type, ManagerUser user) {
        super(source);
        this.type = type;
        this.user = user;
    }
}
