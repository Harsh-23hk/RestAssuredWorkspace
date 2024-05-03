package com.restassuredworkspace.Test.Annotation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeePojo {




    private String name;
    private String lastName;
    private String gender;
    private int age;
    private double salary;
    private boolean isMarried;
    private String[] hobbies;
    private List<String> degrees;
    private Map<String, String> familymembers;


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

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getFamilymembers() {
        return familymembers;
    }

    public void setFamilymembers(Map<String, String> familymembers) {
        this.familymembers = familymembers;
    }

    public List<String> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<String> degrees) {
        this.degrees = degrees;
    }

    public EmployeePojo(String name, String lastName, String gender, int age, double salary, boolean isMarried) {

        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;
    }

    public EmployeePojo() {

    }

}
