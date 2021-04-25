package com.homework.collect;

import java.util.Objects;

public class TestElement implements Comparable{
    private String element;

    public TestElement(String element) {
        this.element = element;
    }

    public TestElement(){

    }
    @Override
    public String toString() {
        return "element: " + element;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestElement that = (TestElement) o;
        return Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    @Override
    public int compareTo(Object o) {
        return element.compareTo(((TestElement) o).element);
    }
}
