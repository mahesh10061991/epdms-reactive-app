package com.topia.epdms.model;

import org.springframework.data.annotation.Id;

public class Employee {
  
  @Id
  private int id;

  private String name;

  private String department;

  private String address;

  private Double salary;

  public Employee() {

  }

  public Employee(String name, String department, String address, Double salary) {
    this.name = name;
    this.department = department;
    this.address = address;
    this.salary = salary;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDepartment() {
    return department;
  }

  public String getAddress() {
    return address;
  }

  public Double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", department='" + department + '\'' +
            ", address='" + address + '\'' +
            ", salary=" + salary +
            '}';
  }
}
