package com.xf.example.generic;

import java.lang.reflect.Method;

public class GenericMethod<T> {

    public <T> void print(T x) {
        System.out.println(x.getClass().getName());
    }

    public Object getstr(T t){
        try {
            Class c = t.getClass();
            Method method = c.getMethod("contains",CharSequence.class);
            Object o = method.invoke(t,"t");
            System.out.println(o.toString());
            return o;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       return null;
    }

    public static void main(String[] args) {
        String str = new String("");
        GenericMethod method = new GenericMethod();
        method.print(" ");
        method.print(10);
        method.print('a');
        method.print(method);

        method.getstr(" ");

    }
}