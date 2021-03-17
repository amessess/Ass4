package com.company;
import java.sql.Connection;
import java.util.ArrayList;


public class ProjectRepository {
    private final IDB db;
    private ArrayList<Employee> employeeList;
    private ArrayList<Project> projectList;

    public ProjectRepository(IDB db) {
        this.db = db;
    }


    public void createProject(Project project) {
        projectList = new ArrayList<Project>();
        employeeList = project.getEmployeeList();
        projectList.add(project);
    }


    public void addEmployee(Employee employee) {
        Connection con = null;
        employeeList.add(employee);
    }


    public int totalCost() {

        int sum = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            sum += employeeList.get(i).getSalary();
        }
        return sum;
    }


    public Project getProject(Project project) {
        if(projectList.contains(project)){
            return project;
        }
        return null;
    }

    public ArrayList<Project> getAllProjects() {
        return projectList;
    }
}
