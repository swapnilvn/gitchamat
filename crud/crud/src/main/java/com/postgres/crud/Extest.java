package com.postgres.crud;

import java.util.HashSet;

public class Extest {
    public static void main(String[] args) {
        HashSet<Student> studentList = new HashSet<>();
        Student st1 = new Student("Nimit", 1);
        Student st2 = new Student("Rahul", 3);
        Student st3 = new Student("Nimit", 2);
        Student st4 = new Student("Nimit", 1);
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        System.out.println(studentList.size()); //3
        st1.id = 3;
        System.out.println(studentList.size()); //3
        System.out.println(studentList);
    }

    public static void printStudentList(HashSet<Student> studentList) {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}