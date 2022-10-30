package com.nestdigital.Nest.dao;

import com.nestdigital.Nest.model.AdminModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface AdminDao extends CrudRepository<AdminModel,Integer> {
    @Modifying
    @Query(value = "DELETE FROM `employee` WHERE `emp_id` =:emp_id",nativeQuery = true)
            void DeleteEmployeeByEmpid(Integer emp_id);

    @Query(value = "SELECT * FROM `employee` WHERE `emp_id`=:id",nativeQuery = true)
    List<AdminModel>SearchEmployeeByEmpId(Integer id);

    @Modifying
    @Query(value = "UPDATE `employee` SET `company_name`=:company_name,`designation`=:designation,`dob`=:dob,`email`=:email,`gender`=:gender,`name`=:name,`password`=:password WHERE `emp_id`=:emp_id",nativeQuery = true)
    void editEmployee(String company_name,String designation,String dob,String email,String gender,String name,String password,Integer emp_id);

    @Query(value = "SELECT `id`, `company_name`, `designation`, `dob`, `email`, `emp_id`, `gender`, `name`, `password` FROM `employee` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<AdminModel> Login(String email,String password);

    @Query(value = "SELECT l.`id`, l.`duration`, l.`emp_id`, l.`end_date`, l.`reason`, l.`start_date`, l.`status`,e.name `type` FROM `employee_leave` l JOIN employee e ON e.emp_id=l.emp_id",nativeQuery = true)
    List<Map<String,String>> viewallLeave();

}
