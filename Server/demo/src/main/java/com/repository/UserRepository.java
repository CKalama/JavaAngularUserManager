package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
											//This CrudRepository needs to invoke the <Model, PrimaryKeyDataType> 
											//For our FindAll Method, we needed JpaRepository instead... Not like enterprise work application
											//Study differences and know how to change if necessary 
public interface UserRepository extends JpaRepository<User, Long>{

}
