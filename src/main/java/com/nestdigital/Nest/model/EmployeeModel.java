package com.nestdigital.Nest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_leave")
public class EmployeeModel {
    @Id
    @GeneratedValue
    private int id;
    private int emp_id;
    private String start_Date;
    private String end_Date;
    private int duration;
    private String type;
    private String reason;
    private String status;

    public EmployeeModel() {
    }

    public EmployeeModel(int id, int emp_id, String start_Date, String end_Date, int duration, String type, String reason, String status) {
        this.id = id;
        this.emp_id = emp_id;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.duration = duration;
        this.type = type;
        this.reason = reason;
        this.status = status;
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

    public String getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(String start_Date) {
        this.start_Date = start_Date;
    }

    public String getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(String end_Date) {
        this.end_Date = end_Date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
