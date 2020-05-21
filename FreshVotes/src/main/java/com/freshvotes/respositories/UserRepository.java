package com.freshvotes.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freshvotes.domain.User;

//Here we need to create an interface because JPA requires to do so
//In that JpaRepo we have to pass the object that we will read from DB and the type of its id
//Because it needs further to iterate over the ids so that it can perform operations
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
