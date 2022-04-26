package com.uom.cs.studentsystem.service.status;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class RegisterStatusFactory {
    private static Map<String, IRegisterStatus> statuses = new HashMap<>();

    static {
        statuses.put("Fully", new FullyRegisterStatus());
        statuses.put("Not", new NotRegisterStatus());
        statuses.put("Pending", new PendingRegisterStatus());
    }

    public static IRegisterStatus getRegisterStatus(String type) {
        return statuses.get(type);
    }
}
