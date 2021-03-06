package com.integration.common;

public class Employee {
    private String EmployeeID;
    private String Name;
    private String Salary;
    public String getEmployeeID() {
        return EmployeeID;
    }
    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getSalary() {
        return Salary;
    }
    public void setSalary(String salary) {
        Salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID='" + EmployeeID + '\'' +
                ", Name='" + Name + '\'' +
                ", Salary='" + Salary + '\'' +
                '}';
    }
}