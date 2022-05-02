package com.uom.cs.studentsystem.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class VerifyData {
    private Map<Object, Object> map = new HashMap<>();

    public void addData(Object key, Object value) {
        map.put(key, value);
    }

    public Object getByKey(Object key) {
        return map.get(key);
    }
}
