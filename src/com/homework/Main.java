package com.homework;

import com.homework.collect.MyLinkedList;
import com.homework.collect.TestElement;

public class Main {

    public static void main(String[] args) {
        //Создание MyLinkedList по массиву
        MyLinkedList<TestElement> myList = new MyLinkedList<>(new TestElement[] {new TestElement("zero")});
        // пример Добавления
        myList.add(new TestElement("one"));
        myList.add(new TestElement("two"));
        myList.add(new TestElement("three"));
        myList.addFirst(new TestElement("four"));
        myList.add(2, new TestElement("five"));
        TestElement testElement = new TestElement("three");
        // пример indexOf
        System.out.println("index element "+ testElement.getElement() + ": "
                + myList.indexOf(testElement));
        // Удаление
        System.out.println(myList.remove(myList.indexOf(testElement)));
        // toString
        System.out.println(myList.toString());
        // set
        System.out.println(myList.set(2, new TestElement("six")));
        //forEach
        for (TestElement element : myList) {
            System.out.print(element + "; ");
        }
    }
}
