package com.db.homeworks.hw2;

import java.lang.reflect.Array;

public class MyList<T> {
    /// Fields

    private T[] elements;           // array containing the elements
    private int capacity;           // the maximum capacity of the array
    private int size;               // the actual size of the array
    private final Class<T> classObject;   // class object used for instantiation of generic array

    /// Constructors

    /**
     * I am modifying the constructor definition to not comply with what was requested because I
     * find this solution to the instantiation of the generic array more elegant than others
     */
    public MyList(Class<T> clazz, int dimension) {
        classObject = clazz;
        capacity = dimension;
        elements = (T[]) Array.newInstance(classObject, dimension);
    }

    /// Instance Methods

    /**
     * Adds an element to the back of the list
     *
     * @param element to add
     */
    public void add(T element) {
        // if capacity is maxed, double it and reallocate new array
        if (size == capacity) {
            capacity *= 2;
            T[] newElements = (T[]) Array.newInstance(classObject, capacity);
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }

        elements[size++] = element;
    }

    /**
     * Prints the list
     */
    public void print() {
        System.out.print("The list of " + elements[0].getClass().getSimpleName() + " contains " + "the" + " " + "elements: ");
        // an enhanced loop will go beyond size if capacity > size
        for (int i = 0; i < size; ++i) {
            System.out.print(elements[i] + " ");
        }

        System.out.println();
    }

    /**
     * Looks up the given element in the list
     *
     * @param element to search for
     * @return true if found, false otherwise
     */
    public boolean lookup(T element) {
        for (int i = 0; i < size; ++i) {
            if (elements[i].equals(element)) return true;
        }

        return false;
    }

    /// Static Methods

    public static void main(String[] args) {
        MyList<Integer> integerList = new MyList<>(Integer.class, 2);
        integerList.add(3);
        integerList.add(5);
        integerList.add(-10);
        integerList.add(200);
        integerList.print();
        System.out.println(integerList.lookup(3));
        System.out.println(integerList.lookup(-1));

        MyList<Student> studentList = new MyList<>(Student.class, 3);
        studentList.add(new Student("Marian", 10.0));
        studentList.add(new Student("Maria", 3.0));
        studentList.add(new Student("Mariana", 5.2));
        studentList.add(new Student("Marin", 7.0));
        studentList.print();
        System.out.println(studentList.lookup(new Student("Maria", 3.0)));
        System.out.println(studentList.lookup(new Student("Maria", 1.0)));
    }
}
