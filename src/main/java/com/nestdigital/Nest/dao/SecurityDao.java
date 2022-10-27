package com.nestdigital.Nest.dao;

import com.nestdigital.Nest.model.SecurityModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {

    @Query(value = "SELECT * FROM `security` WHERE `security_id`=:security_id",nativeQuery = true)
    List<SecurityModel> viewSecuritySingle(Integer security_id);
}
