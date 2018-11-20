package com.xf.example.comparable;

import java.util.Comparator;

/**
 * https://www.cnblogs.com/szlbm/p/5504634.html
 *
 * 1、一个对象不支持自己和自己比较（没有实现Comparable接口），但是又想对两个对象进行比较
 * 2、一个对象实现了Comparable接口，但是开发者认为compareTo方法中的比较方式并不是自己想要的那种比较方式
 */

public class DomainComparator implements Comparator<Domain> {
    public int compare(Domain domain1, Domain domain2) {
        if (domain1.getStr().compareTo(domain2.getStr()) > 0)
            return 1;
        else if (domain1.getStr().compareTo(domain2.getStr()) == 0)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        Domain d1 = new Domain("c");
        Domain d2 = new Domain("c");
        Domain d3 = new Domain("b");
        Domain d4 = new Domain("d");
        DomainComparator dc = new DomainComparator();
        System.out.println(dc.compare(d1, d2));
        System.out.println(dc.compare(d1, d3));
        System.out.println(dc.compare(d1, d4));
    }
}