package com.company;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        EmployeeRepository re = new EmployeeRepository(db);
        ProjectRepository re1 = new ProjectRepository(db);
        FrontEnd front = new FrontEnd(re,re1);

        front.start();

    }
}

