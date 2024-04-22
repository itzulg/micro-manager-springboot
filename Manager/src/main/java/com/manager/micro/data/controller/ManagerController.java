package com.manager.micro.data.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manager.micro.data.model.Manager;
import com.manager.micro.data.model.RequestDataManager;
import com.manager.micro.data.model.ResponseDataManager;
import com.manager.micro.data.servicee.ManagerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Valid
@RequestMapping("/api")
@Slf4j

public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	@PostMapping(value = "/manager/list/retrieve")
	public ResponseEntity<?> getManagerList(){
		managerService.getListManagers();
		return new ResponseEntity<List<Manager>>(managerService.getListManagers(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/manager/id/retrieve", params = {"id"})
	public ResponseEntity<?> getManagerId(@RequestParam Long id){
		return new ResponseEntity<Manager>(managerService.getManagerById(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/manager")
	public ResponseEntity<?> updateManager(@RequestBody @Valid Manager manager){ 
		log.info("Start process to update - request: {}", manager);
		managerService.updateManager(manager);
		return new ResponseEntity<String>("Updated Manager Data", HttpStatus.OK);
	}
	
	@PostMapping(value = "/manager/create")
	public ResponseEntity<?> createManager(@RequestBody @Valid Manager manager){ 
		managerService.createManager(manager);
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/manager/remove", params = {"id"})
	public ResponseEntity<?> deleteManager(@RequestParam Long id){
		managerService.deleteManagerData(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@PostMapping(value="/manager/retrieve/data")
	public ResponseEntity<?> getManagersData(@RequestBody @Valid RequestDataManager requestData){
		return new ResponseEntity<ResponseDataManager>(managerService.getResponseManager(requestData), HttpStatus.OK);
	}

}
