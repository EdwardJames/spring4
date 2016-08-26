package com.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<Zous> zousList = new ArrayList<>();
        Zous zous = new Zous();
        zous.setAge(1);
        zous.setName("aaa");
        zous.setNum(101);
        Zous zous2 = new Zous();
        zous2.setAge(2);
        zous2.setName("bbb");
        zous2.setNum(102);
        zousList.add(zous2);
        zousList.add(zous);

        zousList.stream().filter(s -> s.getAge() == 1).forEach(s -> s.setName("AAA"));
        List<String> str = new ArrayList<>();
        zousList.stream().limit(5).forEach((a) -> System.out.println(a.getName()));
        System.out.println(zousList.parallelStream().mapToInt(p -> p.getNum()).sum());
        List<Integer> listInteger = new ArrayList<>();
        zousList.stream().filter(s->s.getNum()==102).forEach(s->listInteger.add(s.getAge()));
      System.out.println("filter+foreach:"+listInteger);  
        // IntSummaryStatistics status = zousList .stream()
        // .mapToInt((x) -> x)
        // .summaryStatistics();
        //
   
      System.out.println(zousList);
      
      List<Integer> list =   zousList.stream().map(s->s.getNum()).collect(Collectors.toList());
      System.out.println("stream().map---"+list);
   
          testCount(zousList, null);
        testMap();
        distinct();
    }
    public static void testSort(List<Zous> zousList){
        for (Zous z : zousList) {
            System.out.println("sort排序前----" + z.getName());
        }
        Collections.sort(zousList, new Comparator<Zous>() {
            @Override
            public int compare(Zous o1, Zous o2) {

                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Zous z : zousList) {
            System.out.println("sort排序后----" + z.getName());
        }
        /**
         * 
         *  sort排序前----bbb
         *  sort排序前----AAA
         *  sort排序后----AAA
         *  sort排序后----bbb
         */
  
    }
public static void distinct(){
    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("A");
    list.add("A");
    list = list.stream().distinct().collect(Collectors.toList());
    System.out.println("distinct-去除重复--"+list);//[A, B, C]
}
    public static void testMap() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("B");
        list =    list.stream().map(s->s.toLowerCase()).collect(Collectors.toList());
        System.out.println(list);//[a, c, b]
        list.sort((a,b)->a.compareTo(b));
        System.out.println(list);//[a, b, c]
        
    }
    

    public static void testCount(List<Zous> zousList, String str) {
        System.out.println("count---"+zousList.stream().filter(s -> s.getAge() == 1).count());
        //count---1

    }
}

class Zous {
    private String name;
    private int age;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}