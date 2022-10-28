package com.nestdigital.Nest.dao;

import com.nestdigital.Nest.model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT l.`id`, l.`duration`, l.`emp_id`, l.`end_date`, l.`reason`, l.`start_date`, l.`status`,e.name `type` FROM `employee_leave` l JOIN employee e ON e.emp_id=l.emp_id WHERE l.emp_id=:emp_id",nativeQuery = true)
    List<Map<String,String>> Viewleave(Integer emp_id);



    @Modifying
    @Query(value = "UPDATE `employee_leave` SET `status`=:status WHERE `emp_id`=:emp_id",nativeQuery = true)
    void acceptByEmployeeId(String status,Integer emp_id);

    @Modifying
    @Query(value = "UPDATE `employee_leave` SET `status`=:status WHERE `emp_id`=:reject_id",nativeQuery = true)
    void rejectByEmployeeId(String status,Integer reject_id);


}
