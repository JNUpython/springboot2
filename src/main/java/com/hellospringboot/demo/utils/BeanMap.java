package com.hellospringboot.demo.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {

    public static Object convertMap(Class type, Map map){

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            Object obj = type.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor: propertyDescriptors) {
                String propertyName = descriptor.getName();
                if (map.containsKey(propertyName)) {
                    Object value = map.get(propertyName);
                    descriptor.getWriteMethod().invoke(obj, value);
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//       public static Map convertBean(Object bean) throws Exception {
//         Class type=bean.getClass();
//         Map returnMap = new HashMap();
//         BeanInfo beanInfo = Introspector.getBeanInfo(type);
//         PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//         for (PropertyDescriptor descriptor:propertyDescriptors) {
//             String propertyName = descriptor.getName();
//             if (!propertyName.equals("class")){
//                 Method readMethod = descriptor.getReadMethod();
//                 Object result = readMethod.invoke(bean);
//                 if (result!=null){
//                     returnMap.put(propertyName,result);
//                 }else {
//                     returnMap.put(propertyName,"");
//                 }
//             }
//         }
//         return returnMap;
//     }
}
