package com.revature.models;

public class Employee {
    int id;
    String name;
    int salary;
    String job_title;

    public Employee() {
    }

    public Employee(int id, String name, int salary, String job_title) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.job_title = job_title;
    }

    public Employee(String name, int salary, String job_title) {
        this.name = name;
        this.salary = salary;
        this.job_title = job_title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", job_title='" + job_title + '\'' +
                '}';
    }
}

