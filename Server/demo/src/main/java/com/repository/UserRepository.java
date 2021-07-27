package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
											//This CrudRepository needs to invoke the <Model, PrimaryKeyDataType> 
public interface UserRepository extends CrudRepository<User, Long>{

}
