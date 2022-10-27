package com.nestdigital.Nest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class AdminModel {
    @Id
    @GeneratedValue
    private int id;
    private int emp_id;
    private String name;
    private String designation;
    private String company_name;

    public AdminModel() {
    }

    public AdminModel(int id, int emp_id, String name, String designation, String company_name) {
        this.id = id;
        this.emp_id = emp_id;
        this.name = name;
        this.designation = designation;
        this.company_name = company_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
