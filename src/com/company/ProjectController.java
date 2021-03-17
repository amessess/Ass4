package com.company;

import java.util.ArrayList;


public class ProjectController {
    private final ProjectRepository repo;

    public ProjectController(ProjectRepository repo) {
        this.repo = repo;
    }
    public String createProject(String name, ArrayList<Employee> employeeList){
        Project project = new Project(name,employeeList);

        return "Project was created";
    }

    public String getProject(Project project){
        Project project1 = repo.getProject(project);

        return (project1 == null ? "Project wasn't found" : project1.toString());
    }

    public int totalCost(){
        return repo.totalCost();
    }

    public ArrayList<Project> getAllProjects(){
        ArrayList<Project> projects = repo.getAllProjects();
        return projects;
    }

    public void setProject(Project project){
        repo.createProject(project);
    }
}

