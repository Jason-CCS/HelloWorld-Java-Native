package com.jason.app;

import com.jason.app.utils.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jc6t on 2015/4/28.
 */
public class HelloReflection {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.jason.app.Print");
            Method method = c.getMethod("print", String.class);
            Object obj = method.invoke(c.newInstance(), "test string");
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            String output=StringUtils.getStringFromStackTrace(e);
            System.out.println(output);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
