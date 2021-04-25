package com.homework.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Собственная реализация MyLinkedList
 * @param <E>
 */
public class MyLinkedList<E> implements LinkedList<E>{
    /**
     * Количество элементов в MyLinkedList
     */
    private int size = 0;

    /**
     * Первый элемент в листе
     */
    private Node<E> head;

    /**
     * Последний элемент в листе
     */
    private Node<E> tail;

    /**
     * Пустая реализация листа
     */
    public MyLinkedList() {

    }

    /**
     * Создание листа на основе Масива
     */
    public MyLinkedList(E[] array) {
        for (E element: array){
            add(element);
        }
    }

    /**
     * Добавляет Node с введеным значением в MyLinkedList
     * @param element - добавляемое значение
     */
    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
            tail.nextNode = null;
        }
        size++;
    }

    /**
     * Добавления значение по индексу в MyLinkedList
     * @param index индекс положения добавляемого элемента в MyLinkedList
     * @param element добавляемое значение
     */
    @Override
    public void add(int index, E element) {
        if (checkByIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + " , Size: " + size);
        }
        if (index == size) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else{
            Node<E> find = findNode(index);
            Node<E> prevN = find.prevNode;
            Node<E> newNode = new Node<>(element);
            newNode.prevNode = prevN;
            newNode.nextNode = find;
            find.prevNode = newNode;
            if (prevN == null) {
                head = newNode;
            } else{
                prevN.nextNode = newNode;
            }
            size++;
        }
    }

    /**
     * Добавить значение в начало MyLinkedList
     * @param element добавляемое значение в MyLinkedList
     */
    public void addFirst(E element){
        Node<E> h = head;
        Node<E> newNode = new Node<>(element);
        newNode.nextNode = h;
        head = newNode;
        if (h == null){
            tail = newNode;
        } else {
            h.prevNode = newNode;
        }
        size++;
    }

    /**
     * Добавить значение в конец MyLinkedList
     * @param element добавляемое значение в MyLinkedList
     */
    public void addLast(E element){
        add(element);
    }

    /**
     * Удаление всех элменетов из списка
     */
    @Override
    public void clear() {
        Node<E> current = head;
        Node<E> next = head;
        while(next != null) {
            next = current.nextNode;
            current.nextNode = null;
            current.prevNode = null;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * Поиск значения по индаксу
     * @param index индекс элемента
     * @return значение элемента
     */
    @Override
    public E get(int index) {
        if (checkByIndex(index)){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        return findNode(index).element;
    }

    /**
     * Поиск индекса по значению
     * @param element Искомый элемент
     * @return индекс элемента в листе, если элемент не найден возврощает -1
     */
    @Override
    public int indexOf(E element) {
        Node<E> current = head;
        int index = -1;
        while(current != null) {
            index++;
            if (current.element.equals(element)){
                break;
            }
            current = current.nextNode;
        }
        return index;
    }


    /**
     * @param index индекс элемнта в MyLinkedList
     * @return значение элемента по индаксу
     */
    @Override
    public E remove(int index) {
        if (checkByIndex(index)){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        return deleteNode(findNode(index));
    }


    /**
     * Удаление узла из MyLinkedList
     * @param find Удаляемый узел
     * @return Удаленное значение
     */
    private E deleteNode(Node<E> find) {
        E element = find.element;
        Node<E> next = find.nextNode;
        Node<E> prev = find.prevNode;

        if (prev == null) {
            head = next;
        } else {
            prev.nextNode = next;
            find.prevNode = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prevNode = prev;
            find.nextNode = null;
        }
        find.element = null;
        size--;
        return element;
    }

    /**
     * Ищет Node по индексу в MyLinkedList
     * @param index значение поиск
     * @return Искомый Node
     */
    private Node<E> findNode(int index){
        Node<E> find;
        if (index < (size >> 1)) {
            find = head;
            for (int i = 0; i < index; i++){
                find = find.nextNode;
            }
        } else {
            find = tail;
            for (int i = size - 1; i > index; i--){
                find = find.prevNode;
            }
        }
        return find;
    }


    /**
     * Замена значение узла по индексу
     * @param index Индекс изменяемого узла
     * @param element на что изменяется значение
     * @return старое значение узла
     */
    @Override
    public E set(int index, E element) {
        if (checkByIndex(index)){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        Node<E> node = findNode(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * получение азмера MyLinkedList
     * @return размер MyLinkedList
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @param index полученый индекс
     * @return boolean границы нахождения индекса
     */
    boolean checkByIndex(int index){
        return index < 0 && index > size;
    }


    /**
     * @param ar Массив того же типа что и MyLinkedList
     * @return масссив значений MyLinkedList
     */
    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(E[] ar) {
        if (ar.length < size) {
            ar = (E[])java.lang.reflect.Array.newInstance(
                    ar.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = ar;
        for (Node<E> el = head; el != null; el = el.nextNode) {
            result[i++] = el.element;
        }
        if (ar.length > size) {
            ar[size] = null;
        }
        return ar;
    }


    /**
     * @return элементы MyLinkedList ввиде строки
     */
    @Override
    public String toString() {
        StringBuilder strMyLinkedList = new StringBuilder();
        Node<E> current = head;
        strMyLinkedList.append("MyLinkedList: ");
        while (current != null){
            strMyLinkedList.append(current.element.toString()).append(", ");
            current = current.nextNode;
        }
        return strMyLinkedList.toString();
    }

    /**
     * Реализует interface Iterator для перебора значений MyLinkedList
     * @return анонимный класс Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                E element = current.element;
                current = current.nextNode;
                return element;
            }

            @Override
            public void remove() {
                deleteNode(current);
            }
        };
    }


    /**
     * Узел MyLinkedList
     * @param <E> Тип узла
     */
    private  static class Node<E> {
        public E element;
        public Node<E> nextNode;
        public Node<E> prevNode;

        public Node() {

        }
        public Node(E element) {
            this.element = element;
        }
    }
}
