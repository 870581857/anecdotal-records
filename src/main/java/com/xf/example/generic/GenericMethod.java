package com.xf.example.generic;

import java.lang.reflect.Method;

public class GenericMethod<T> {

    public <T> void print(T x) {
        System.out.println(x.getClass().getName());
    }

    public T getstr(T t){
        try {
            Method method = t.getClass().getMethod("contains",t.getClass());
            Object o = method.invoke(t,"t");
            System.out.println(o.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return t;
    }

    public static void main(String[] args) {
        GenericMethod method = new GenericMethod();
        method.print(" ");
        method.print(10);
        method.print('a');
        method.print(method);

        method.getstr(" ");
    }
}