package com.wq.common.util;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 王骞
 * @Date 2023/7/13 14:09
 * @Version 1.0
 */
public class ObjectToMapConverter {
    public static Map<String, Object> convert(Object obj) {
        Map<String, Object> map = new HashMap<>();
        // 获取Object对象的Class
        Class<?> clazz = obj.getClass();
        // 获取所有字段（包括私有字段）
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);  // 设置可访问私有字段
            try {
                // 获取字段名和字段值，并放入Map中
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);
                map.put(fieldName, fieldValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
