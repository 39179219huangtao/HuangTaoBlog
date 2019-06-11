package com.hyc.shop.admin.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import sun.tools.tree.ThisExpression;

import java.io.IOException;
import java.util.*;

/**
 * @program hyc
 * @description:
 * @author: huangtao
 * @create: 2019/05/16 17:22
 */

public class app {

    static class Student implements Comparable<Student> {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;

        }

        @Override
        public int compareTo(final Student o) {
            if (o.score < this.score) {
                return 1;
            } else if (o.score > this.score) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        Set a=new TreeSet();

//
//        TreeMap<Student, String> map = new TreeMap<>((Student o1, Student o2) -> {
//            if (o1.score < o2.score) {
//                return 1;
//            } else if (o1.score > o2.score) {
//                return -1;
//            }
//            return 0;
//
//        });
        final LinkedList<Student> students = new LinkedList<>();

        // TreeMap<Student, String> map = new TreeMap<Student, String>();
        Student s1 = new Student("张三", 60);
        Student s2 = new Student("李四", 70);
        Student s3 = new Student("王五", 80);
        Student s4 = new Student("赵六", 90);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        System.out.println(students.get(1));
//        map.put(s1, "1");
//        map.put(s2, "2");
//        map.put(s3, "3");
//        map.put(s4, "4");

//        Map map1 = ((TreeMap<Student, String>) map).subMap(s1, s3);
//        System.out.println(JSON.json(map1));

//
//        Map map2 = ((TreeMap<Student, String>) map).headMap(s3);
//        System.out.println(JSON.json(map2));

//
//        Map map3 = ((TreeMap<Student, String>) map).tailMap(s3);
//        System.out.println(JSON.json(map3));

    }

}
