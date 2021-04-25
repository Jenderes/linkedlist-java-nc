package com.homework;

import com.homework.collect.MyLinkedList;
import com.homework.collect.TestElement;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class SpeedTest {
    public static void main(String[] args) {
        int countElements = 10000;
        compareMyLinkedList(countElements);
        compareList(countElements);
        compareSetCollections(countElements);
        compareMap(countElements);
    }


    public static void compareMyLinkedList(int countElements) {
        System.out.println("\n\n################# LinkedList vs MyLinkedList #################");
        LinkedList<TestElement> linkedList = new LinkedList<>();
        MyLinkedList<TestElement> myLinkedList = new MyLinkedList<>();
        long start, finish, elapsed;

        System.out.println("\n add");
        //LinkedList add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++) {
            linkedList.add(new TestElement(i + ""));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedList Прошло времени, нс: " + elapsed);

        //MyLinkedList add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++) {
            myLinkedList.add(new TestElement(i + ""));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("MyLinkedList Прошло времени, нс: " + elapsed);

        System.out.println("\n get");
        // LinkedList get
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++) {
            linkedList.get(i);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedList Прошло времени, нс: " + elapsed);

        //MyLinkedList get
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++) {
            myLinkedList.get(i);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("MyLinkedList Прошло времени, нс: " + elapsed);

        System.out.println("\n remove");
        //LinkedList remove
        start = System.nanoTime();
        for (int i = 1; i < countElements-2; i++) {
            linkedList.remove((countElements - i)/2);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedList Прошло времени, нс: " + elapsed);

        //MyLinkedList remove
        start = System.nanoTime();
        for (int i = 1; i < countElements-2; i++) {
            myLinkedList.remove((countElements-i)/2);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("MyLinkedList Прошло времени, нс: " + elapsed);
    }

    public  static void  compareList(int countElements) {
        System.out.println("\n\n################# LinkedList vs ArrayList #################");
        LinkedList<TestElement> linkedList = new LinkedList<>();
        ArrayList<TestElement> arrayList = new ArrayList<>();
        long start, finish, elapsed;

        System.out.println("\n add");
        // LinkedList add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++) {
            linkedList.add(new TestElement());
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedList Прошло времени, нс: " + elapsed);

        //ArrayList add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++) {
            arrayList.add(new TestElement());
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("ArrayList Прошло времени, нс: " + elapsed);

        System.out.println("\n get");
        // LinkedList get
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++) {
            linkedList.get(i);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedList Прошло времени, нс: " + elapsed);

        //ArrayList get
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++) {
            arrayList.get(i);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("ArrayList Прошло времени, нс: " + elapsed);

        System.out.println("\n remove");
        //LinkedList remove
        start = System.nanoTime();
        for (int i = 1; i < countElements-2; i++) {
            linkedList.remove((countElements - i)/2);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedList Прошло времени, нс: " + elapsed);

        //ArrayList remove
        start = System.nanoTime();
        for (int i = 1; i < countElements-2; i++) {
            arrayList.remove((countElements-i)/2);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("ArrayList Прошло времени, нс: " + elapsed);
    }

    public static void compareSetCollections(int countElements) {
        System.out.println("\n\n################# HashSet vs LinkedHasSet vs TreeSet #################");
        long start, finish, elapsed;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < countElements; i++){
            arrayList.add(generateString());
        }
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        System.out.println( "\n add");
        // HashSet add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            hashSet.add(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("HashSet Прошло времени, нс: " + elapsed);

        // LinkedHashSet add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            linkedHashSet.add(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LikedHashSet Прошло времени, нс: " + elapsed);

        //TreeSet
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            treeSet.add(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("TreeSet Прошло времени, нс: " + elapsed);

        System.out.println( "\n contains");
        // HashSet contains
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            hashSet.contains(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("HashSet Прошло времени, нс: " + elapsed);

        // LinkedHashSet contains
        for (int i = 0; i < countElements; i++){
            linkedHashSet.contains(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedHashSet Прошло времени, нс: " + elapsed);

        //TreeSet contains
        for (int i = 0; i < countElements; i++){
            treeSet.contains(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("TreeSet Прошло времени, нс: " + elapsed);

        System.out.println( "\n remove");
        // HashSet remove
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            hashSet.remove(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("HashSet Прошло времени, нс: " + elapsed);

        //LinkedHashSet remove
        for (int i = 0; i < countElements; i++){
            linkedHashSet.remove(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedHashSet Прошло времени, нс: " + elapsed);

        //TreeSet remove
        for (int i = 0; i < countElements; i++){
            treeSet.remove(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("TreeSet Прошло времени, нс: " + elapsed);
    }

    public static void compareMap(long countElements) {
        System.out.println("\n\n################# HashMap vs LinkedHasMap vs TreeMap #################");
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        long start, finish, elapsed;

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < countElements; i++){
            arrayList.add(generateString());
        }

        System.out.println( "\n add");
        // HashMap add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            hashMap.put(arrayList.get(i), i);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("HashMap Прошло времени, нс: " + elapsed);

        // LinkedHashMap add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            linkedHashMap.put(arrayList.get(i),i);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LikedHashMap Прошло времени, нс: " + elapsed);

        //TreeMap add
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            treeMap.put(arrayList.get(i),i);
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("TreeMap Прошло времени, нс: " + elapsed);

        System.out.println( "\n get");
        // HashMap get
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            hashMap.get(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("HashMap Прошло времени, нс: " + elapsed);

        // LinkedHashMap get
        for (int i = 0; i < countElements; i++){
            linkedHashMap.get(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedHashMap Прошло времени, нс: " + elapsed);

        //TreeMap get
        for (int i = 0; i < countElements; i++){
            treeMap.get(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("TreeMap Прошло времени, нс: " + elapsed);

        System.out.println( "\n remove");
        // HashMap remove
        start = System.nanoTime();
        for (int i = 0; i < countElements; i++){
            hashMap.remove(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("HashMap Прошло времени, нс: " + elapsed);

        //LinkedHashMap remove
        for (int i = 0; i < countElements; i++){
            linkedHashMap.remove(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("LinkedHashMap Прошло времени, нс: " + elapsed);

        //TreeMap remove
        for (int i = 0; i < countElements; i++){
            treeMap.remove(arrayList.get(i));
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("TreeMap Прошло времени, нс: " + elapsed);
    }

    public static String generateString() {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();
        int targetStringLength = random.nextInt(20)+1;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }
}
