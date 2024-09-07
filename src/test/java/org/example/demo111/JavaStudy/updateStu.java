package org.example.demo111.JavaStudy;

import java.util.Iterator;
import java.util.TreeSet;
/*
Set集合
        Set集合对象不按特定的方式排序，只是简单地将对象加入集合中，但是Set集合中不能有重复对象；
        Set集合由Set接口和实现Set接口的实现类组成。Set接口也继承了Collection类，
        所以实现Set接口的集合类也包含Collection相关的方法。
*/


public class updateStu implements Comparable<Object> {   //创建类，实现Comparator接口
    String name;
    long id;

    public updateStu(String name, int id) {      //构造方法
        this.name = name;
        this.id = id;
    }

    public int compareTo(Object o) {
        updateStu up_stu = (updateStu) o;
        int result = id > up_stu.id ? 1 : (id == up_stu.id ? 0 : -1);   //对比两个对象id大小
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static void main(String[] args) {
        updateStu stu1 = new updateStu("春田1", 101);
        updateStu stu2 = new updateStu("春田2", 102);
        updateStu stu3 = new updateStu("春田3", 103);
        updateStu stu4 = new updateStu("春田4", 104);

        TreeSet<updateStu> tree = new TreeSet<>();
        tree.add(stu1);
        tree.add(stu2);
        tree.add(stu3);
        tree.add(stu4);

        Iterator<updateStu> it = tree.iterator();       //Set集合中所有对象的迭代器
        System.out.println("TreeSet集合中的所有元素：");
        while (it.hasNext()) {
            updateStu up_stu = (updateStu) it.next();
            System.out.println(up_stu.getId() + " " + up_stu.getName());
        }

        it = tree.headSet(stu3).iterator();    //截取stu2对象之前的所有对象集合
        System.out.println("截取前面的部分集合：");
        while (it.hasNext()) {
            updateStu up_stu = (updateStu) it.next();
            System.out.println(up_stu.getId() + " " + up_stu.getName());
        }

        it = tree.subSet(stu1, stu3).iterator();
        System.out.println("截取中间部分的集合：");
        while (it.hasNext()) {
            updateStu up_stu3 = (updateStu) it.next();
            System.out.println(up_stu3.getId() + " " + up_stu3.getName());
        }
    }
}

