package org.example.demo111.JavaStudy;


import java.util.*;     //导入java.util包，所有使用集合的实例都要添加该语句
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Muster {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();   // 实例化集合类对象
        list.add("a");  //向集合中添加数据
        list.add("b");
        list.add("c");
        Iterator<String> it = list.iterator();  //创建list这个集合的迭代器
        while (it.hasNext()) {      //判断是否有下一个元素
            String str = (String) it.next();    //迭代器.next()方法用于获取下一个元素
            System.out.println(str);
        }

        //LinkedList类实现List接口的语法：
        List<String> list1 = new ArrayList<>();  //创建集合对象
        list1.add("a");
        list1.add("b");
        list1.add("c");
        int i = (int) (Math.random() * list1.size());   //根据结合长度获取0~2之间的随机数
        System.out.println("随机获得集合中的元素：" + list1.get(i));
        list1.remove(2); //将索引为2的位置的元素从集合中移除
        System.out.println("将索引为2位置的元素移除后，集合的元素有：");
        Iterator<String> it1 = list1.iterator();
        int j = 0;
        while (j < list1.size()) {
            System.out.println(list1.get(j));
            j++;
        }






    }
}
