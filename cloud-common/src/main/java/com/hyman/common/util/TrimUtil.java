package com.hyman.common.util;

import cn.hutool.core.util.ReflectUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class TrimUtil {

    private static Logger log = LoggerFactory.getLogger(TrimUtil.class);

    public static void trimBean(Object model){

        Class clazz = model.getClass();
        Field[] fields = ReflectUtil.getFields(clazz);
        for (Field field : fields) {
            if ("class java.lang.String".equals(field.getGenericType().toString())) {
                String value = (String) ReflectUtil.getFieldValue(model, field);
                if (value != null) {
                    value = StringUtils.deleteWhitespace(value);
                    field.setAccessible(true);
                    try {
                        field.set(model, value);
                    } catch (IllegalAccessException e) {
                        log.info("查询条件去除空格异常");
                    }
                }
            }
        }

    }

//    public static void main(String[] args) {
//        DriverLabelForm driverLabelForm = new DriverLabelForm();
//        driverLabelForm.setRemark("li  sss");
//        driverLabelForm.setDriverId("djka   fasdf  ");
//        trimBean(driverLabelForm);
//        System.out.println(driverLabelForm.getRemark());
//        System.out.println(driverLabelForm.getDriverId());
//    }

}