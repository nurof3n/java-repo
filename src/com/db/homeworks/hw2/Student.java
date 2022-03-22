package com.db.homeworks.hw2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Student implements Comparable<Student> {
    /// Fields

    private String name;
    private double grade;

    /// Constructors

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    /// Get/Set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    /// Overridden Methods

    /**
     * Compares two Student objects by their grades, in decreasing order
     */
    @Override
    public int compareTo(Student o) {
        return Double.compare(o.grade, this.grade);
    }

    /**
     * Two students are equal iff their fields are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.grade, grade) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    /// Static Methods

    public static void main(String[] args) {
        Student[] students = {
                new Student("Gigi1", 10.0),
                new Student("Gigi2", 3.0),
                new Student("Gigi3", 2.9),
                new Student("Gigi4", 1.5),
                new Student("Gigi5", 5.0),
                new Student("Gigi6", 8.2),
                new Student("Gigi7", 3.9),
                new Student("Gigi8", 4.99999999)};

        Map<Long, TreeSet<Student>> map = new HashMap<>();

        // put the keys in the map, with empty sets as values
        for (int i = 0; i <= 10; ++i) {
            map.put((long) i, new TreeSet<>());
        }

        // populate the map
        for (var student : students) {
            map.get(Math.round(student.getGrade())).add(student);
        }

        // print the map
        for (var entry : map.entrySet()) {
            System.out.println("Grade: " + entry.getKey() + ", with students: " + (entry.getValue().isEmpty() ? "none" : ""));
            for (var student : entry.getValue()) {
                System.out.println("\t" + student);
            }
        }
    }
}
