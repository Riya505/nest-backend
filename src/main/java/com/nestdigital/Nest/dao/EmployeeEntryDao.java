package com.nestdigital.Nest.dao;

import com.nestdigital.Nest.model.EmployeeEntryModel;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeEntryDao extends CrudRepository<EmployeeEntryModel,Integer> {
}
