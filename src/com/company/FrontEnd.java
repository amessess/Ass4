package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FrontEnd {

    private final EmployeeController controller;
    private final ProjectController projectController;
    private final Scanner scanner;

    public FrontEnd(EmployeeRepository employeeRepository, ProjectRepository repo) {
        controller = new EmployeeController(employeeRepository);
        projectController = new ProjectController(repo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to IT Company");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee (id)");
            System.out.println("3. Add employee by id");
            System.out.println("4. Create new project");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                } else if (option == 4) {
                    createProjectMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    public void getAllEmployeesMenu() {
        String response = controller.getAllEmployees();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Enter id");

        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter position of employee in company:" +
                "For example: Junior/middle/senior/lead engineer, IT project manager, IT Analysts, etc. )");
        scanner.nextLine();
        String position = scanner.nextLine();
        System.out.println("Please enter salary of employee");
        int salary = scanner.nextInt();
        String response = controller.createEmployee(name, surname, position, salary);
        System.out.println(response);
    }

    public void createProjectMenu() {
        System.out.println("Write project name, how many employee in project, and employers' id");
        String name = scanner.next();
        int n = scanner.nextInt();
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = scanner.nextInt();
        }
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        ArrayList<Employee> projectEmployeeList = new ArrayList<Employee>();
        employeeList = controller.getAllEmployeesList();
        System.out.println("Employee list:");
        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = 0; j < n; j++) {
                if (employeeList.get(i).getId() == id[j]) {
                    projectEmployeeList.add(employeeList.get(i));
                    System.out.println(employeeList.get(i).toString());

                }
            }
        }
        Project project = new Project(name, projectEmployeeList);
        projectController.setProject(project);
        System.out.println("Total cost of your project for one month: "+projectController.totalCost()+" KZT");

    }

}

