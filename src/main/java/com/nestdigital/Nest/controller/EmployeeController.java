package com.nestdigital.Nest.controller;

import com.nestdigital.Nest.dao.EmployeeDao;
import com.nestdigital.Nest.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leave",consumes = "application/json",produces = "application/json")
    public String leaveRequest(@RequestBody EmployeeModel employee){
        System.out.println(employee.toString());
        dao.save(employee);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/viewLeaveRequest",consumes = "application/json",produces = "application/json")
    List<Map<String,String>> viewLeave(@RequestBody EmployeeModel employee){
        return (List<Map<String, String>>) dao.Viewleave(employee.getEmp_id());
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/UpdateLeaveRequest",consumes = "application/json",produces = "application/json")
    public String UpdateLeaveRequest(@RequestBody EmployeeModel update){
        dao.UpdateLeaveRequestByEmployeeId(update.getStatus(),update.getEmp_id());
        return "{status:'success'}";
    }



}
