package com.nestdigital.Nest.controller;

import com.nestdigital.Nest.dao.AdminDao;
import com.nestdigital.Nest.model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminDao dao;
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/EmployeeEntry",consumes = "application/json",produces = "application/json")
    public String EmployeeEntry(@RequestBody AdminModel employee){
        System.out.println(employee.toString());
        dao.save(employee);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/ViewEmployee")
    public List<AdminModel> ViewEmployee(){
        return (List<AdminModel>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deleteEmployee",consumes = "application/json",produces = "application/json")
    public String deleteEmployee(@RequestBody AdminModel delete){
        dao.DeleteEmployeeByEmpid(delete.getEmp_id());
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/searchEmployee",consumes = "application/json",produces = "application/json")
    public List<AdminModel> searchEmployee(@RequestBody AdminModel search){
        return (List<AdminModel>) dao.SearchEmployeeByEmpId(search.getEmp_id());
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/EditEmployee",consumes = "application/json",produces = "application/json")
    public String EditEmployee(@RequestBody AdminModel edit){
        dao.editEmployee(edit.getCompany_name(),edit.getDesignation(),edit.getDob(),edit.getEmail(),edit.getGender(),edit.getName(),edit.getPassword(), edit.getEmp_id());
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<AdminModel> login(@RequestBody AdminModel login){
        return (List<AdminModel>) dao.Login(login.getEmail(),login.getPassword());
    }

    @CrossOrigin
    @GetMapping("/viewAllLeave")
    public List<Map<String,String>> viewLeave(){
        return (List<Map<String, String>>) dao.viewallLeave();
    }


}
