package com.company;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private final EmployeeRepository repo;
    public EmployeeController(EmployeeRepository repo){
        this.repo=repo;
    }
    public String createEmployee(String name, String surname, String position, int salary) {
        Employee employee=new Employee(name,surname,position,salary);


        boolean created = repo.createEmployee(employee);

        return (created ? "Employee creation error!" : "Employee was created!");
    }

    public String getEmployee(int id) {
        Employee employee = repo.getEmployee(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString();
    }
    public ArrayList<Employee> getAllEmployeesList(){

        return (ArrayList<Employee>) repo.getAllEmployees();
    }



}
