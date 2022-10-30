package com.nestdigital.Nest.controller;

import com.nestdigital.Nest.dao.EmployeeEntryDao;
import com.nestdigital.Nest.model.EmployeeEntryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployeeEntryController {
    @Autowired
    private EmployeeEntryDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmployeeEntry",consumes = "application/json",produces = "application/json")
    public String addEmployeeEntry(@RequestBody EmployeeEntryModel add){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentDate=String.valueOf(dt.format(now));
        dao.save(add);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewEmployeeEntry")
    public List<EmployeeEntryModel>viewEmployeeEntry(){
        return (List<EmployeeEntryModel>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/checkoutEmployee",consumes = "application/json",produces = "application/json")
    public String checkoutEmployee(@RequestBody EmployeeEntryModel checkout){
        DateTimeFormatter td=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentDateTime=String.valueOf(td.format(now));
        checkout.setCheckOut(currentDateTime);
        dao.checkoutById(checkout.getCheckOut(),checkout.getEntryId());
        return "{status:'success'}";
    }


}
