package com.xf.example.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by DCJS
 * 2019/5/2.
 */
public class ReflectDemo {

    public static void demo01(){
        //获取反射对象：Class,1.Class.forName(全类名),2.XX.class 3.对象.getClass()
        //1.Class.forName(全类名);
        try {
            Class<?> perClazz = Class.forName("com.xf.example.reflect.Person");
            System.out.println(perClazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2.类名.class
        Class<?> perClazz2 = Person.class;
        System.out.println(perClazz2.getName());

        //3.对象.getClass()
        Person per = new Person();
        Class<?> perClazz3 = per.getClass();
        System.out.println(perClazz3);
    }

    /**
     * 公有方法
     */
    public static void demo02(){
        //Class入口
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.xf.example.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method method[] = perClazz.getMethods();
        for(Method method1 : method){
            System.out.println(method1);
        }
    }

    public static void demo03(){
        //Class入口
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.xf.example.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?>[] interfaces = perClazz.getInterfaces();
        for(Class interface1 : interfaces){
            System.out.println(interface1);
        }
    }

    public static void demo04(){
        //Class入口
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.xf.example.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> superclass = perClazz.getSuperclass();
        System.out.println(superclass);
    }

    public static void demo05(){
        //Class入口
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.xf.example.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = perClazz.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }
    }

    public static void demo06(){
        //Class入口
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.xf.example.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] constructors = perClazz.getFields();
        for(Field field : constructors){
            System.out.println(field);
        }
    }

    /**
     * 本类的所有方法，忽略修饰符
     */
    public static void demo07(){
        //Class入口
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.xf.example.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = perClazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method);
        }

        Field[] fields = perClazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field);
        }
    }


    public static void demo08() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Class入口
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.xf.example.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method method = perClazz.getDeclaredMethod("privateMethod",null);
        method.setAccessible(true);
        method.invoke(perClazz,null);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        demo01();
//        demo02();
//        demo03();
//        demo04();
//        demo05();
//        demo06();
        demo08();
    }

}
