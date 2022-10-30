package com.nestdigital.Nest.dao;

import com.nestdigital.Nest.model.EmployeeEntryModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeEntryDao extends CrudRepository<EmployeeEntryModel,Integer> {

    @Modifying
    @Query(value = "UPDATE `employee_entry` SET `check_out`=:check_out WHERE `entry_id`=:entry_id",nativeQuery = true)
    void checkoutById(String check_out,Integer entry_id);
}
