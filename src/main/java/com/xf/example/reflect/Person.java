package com.xf.example.reflect;

/**
 * Created by DCJS
 * 2019/5/2.
 */
public class Person implements MyInterFace{
    private int id;
    private String name;
    private String age;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static void staticMethod(){
        System.out.println("static method");
    }

    private static void privateMethod(){
        System.out.println("private method");
    }

    @Override
    public void interfaceMethod() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
