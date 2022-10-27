package com.nestdigital.Nest.controller;

import com.nestdigital.Nest.dao.SecurityDao;
import com.nestdigital.Nest.model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/SecurityData",consumes = "application/json",produces = "application/json")
    public String SecurityData(@RequestBody SecurityModel security){
        System.out.println(security.toString());
        dao.save(security);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewSecurity")
    public List<SecurityModel> viewSecurity(){
        return (List<SecurityModel>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/viewSingleSecurity")
    public List<SecurityModel> viewsingle(@RequestBody SecurityModel security){
        return (List<SecurityModel>) dao.viewSecuritySingle(security.getSecurityId());
    }




}
