package com.xf.tools.collectiontools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * list删除元素总结
 */
public class CollectionTool<T> {

    /**
     * 遍历的时候漏掉某些元素
     * @param list
     * @return
     */
    public List<T> removeOfFor(List<T> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("a"))
                list.remove(i);
        }
        return list;
    }

    public List<T> removeOfForA(List<T> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("a")){
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    /**
     * 删除元素后继续循环会报错误信息ConcurrentModificationException
     * 使用break跳出
     * @param list
     * @return
     */
    public List<T> removeOfForE(List<T> list){
        for(T x:list){
            if(x.equals("del")){
                list.remove(x);
                break;
            }
        }
        return list;
    }

    public List<T> removeOfIterator(List<T> list){
        Iterator<T> it = list.iterator();
        while(it.hasNext()){
            T x = it.next();
            if(x.equals("a")){
                it.remove();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("a");
        list.add("a");
        CollectionTool collectionTool = new CollectionTool();
//        collectionTool.removeOfFor(list);
//        System.out.println(list);

//        collectionTool.removeOfForA(list);
//        System.out.println(list);

        collectionTool.removeOfIterator(list);
        System.out.println(list);

    }
}
