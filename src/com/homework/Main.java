package com.homework;

import com.homework.collect.MyLinkedList;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add("Привет");
        mylist.add("Обучающимся");
        mylist.add("На");
        mylist.add("JavaRush");
        mylist.addFirst("none");
        mylist.set(2, "edit");
        mylist.add(2, "mirror");
        System.out.println(Arrays.toString(mylist.toArray(new String[]{""})));
    }
}
