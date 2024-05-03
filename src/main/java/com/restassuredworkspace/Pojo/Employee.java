package com.restassuredworkspace.Pojo;

public class Employee {

    private String name;
    private String lastName;
    private String gender;
    private int age;
    private double salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, String lastName, String gender, int age, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }


}
