package com.manager.micro.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.micro.data.model.Manager;


@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

	 @Query("SELECT  p from Manager p")  
	  public Optional<List<Manager>> findListManager();
	  
	  public Optional<Manager> findById(Long id); 
	  
	
}
