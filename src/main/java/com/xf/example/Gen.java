package com.xf.example;

/**
 * https://www.jb51.net/article/127090.htm
 * @param <T>
 */
public class Gen<T> {

    private T t;

    public Gen(T t){
        this.t = t;
    }
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }

    public void showType(){
        System.out.println("T的实际类型是：" + t.getClass().getName());
    }

    public static void main(String[] args) {
        Gen<Integer> gen = new Gen<Integer>(1);
        gen.showType();

        int i = gen.getT();
        System.out.println(" value = " + i);
        System.out.println(" ====================== ");

        //定义泛型类Gen的一个String的版本
        Gen<String>strObj = new Gen<String>("Hello Gen!");
        strObj.showType();
        String s = strObj.getT();
        System.out.println(" value = " + s);

    }
}