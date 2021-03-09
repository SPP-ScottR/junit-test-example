package com.example.demo.pojo;

public class Student {
    private String id;
    private String name;
    private int grade;

    public Student() { }

    public Student(String id) {
        setId(id);
        setName("John Smith");
        setGrade(7);
    }

    public Student(String id, String name, int grade) {
        setId(id);
        setName(name);
        setGrade(grade);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
