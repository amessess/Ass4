package com.company;

import java.util.ArrayList;

public class Project {
    private int id;
    private String name;
    private int totalCost;
    private ArrayList<Employee> employeeList;
    private int id_gen=0;

    public Project(){
        id_gen++;
    }

    public Project(String name, ArrayList<Employee> employeeList) {
        setName(name);
        setEmployeeList(employeeList);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString(){
        return "Project| "+name+" Total cost: "+totalCost;
    }
}

