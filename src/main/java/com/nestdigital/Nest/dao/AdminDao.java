package com.nestdigital.Nest.dao;

import com.nestdigital.Nest.model.AdminModel;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<AdminModel,Integer> {
}
