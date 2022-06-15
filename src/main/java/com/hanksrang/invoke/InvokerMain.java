package com.hanksrang.invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokerMain {

    public static Object getFieldAnnoProp(String className, String clazzAnno, String annoMethod, String prop) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] fields = Class.forName(className).getDeclaredFields();
        Class classAnno = Class.forName(clazzAnno);
        for (Field f : fields) {
            if(f.isAnnotationPresent(classAnno)){
                String fieldName = f.getName();
                if (fieldName.equals(prop)) {
                    Method method = f.getAnnotation(classAnno).annotationType().getMethod(annoMethod);
                    Object value = method.invoke(f.getAnnotation(classAnno));
                    return value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            InvokerMain.getFieldAnnoProp("com.hanksrang.pojo.ExportVo", "com.hanksrang.anno.Excel", "name", "studentName");
        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
