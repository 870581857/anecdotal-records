package com.xf.example.generic;

public class GenericMethod<T> {

    public <T> void print(T x) {
        System.out.println(x.getClass().getName());
    }

    public T getstr(T t){

        return null;
    }

    public static void main(String[] args) {
        GenericMethod method = new GenericMethod();
        method.print(" ");
        method.print(10);
        method.print('a');
        method.print(method);
    }
}