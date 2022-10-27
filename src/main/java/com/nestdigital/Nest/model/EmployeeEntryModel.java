package com.nestdigital.Nest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_entry")
public class EmployeeEntryModel {

    @Id
    @GeneratedValue
    private int id;
    private int entryId;
    private String checkIn;
    private String checkOut;

    public EmployeeEntryModel() {
    }

    public EmployeeEntryModel(int id, int entryId, String checkIn, String checkOut) {
        this.id = id;
        this.entryId = entryId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
