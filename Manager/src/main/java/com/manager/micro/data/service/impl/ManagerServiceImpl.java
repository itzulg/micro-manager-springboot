package com.manager.micro.data.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.manager.micro.data.exceptions.NotFoundException;
import com.manager.micro.data.model.Manager;
import com.manager.micro.data.model.RequestDataManager;
import com.manager.micro.data.model.ResponseDataManager;
import com.manager.micro.data.repository.ManagerRepository;
import com.manager.micro.data.servicee.ManagerService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service

public class ManagerServiceImpl implements ManagerService{
	
	private ManagerRepository repository;
	
	public ManagerServiceImpl(ManagerRepository repository) {
		
		this.repository= repository;
		
	}

	@Override
	public List<Manager> getListManagers() {
		 Optional<List<Manager>> listManagers	= repository.findListManager();
		  if(listManagers.isPresent()) {
			return listManagers.get();   
		  } else {
			  return new ArrayList<>();
		  }
	}

	@Override
	public Manager getManagerById(Long id) {
		Optional<Manager> managerId	= repository.findById(id);
		  if(managerId.isPresent()) {
			log.debug("Manager buscado con el id: {}", id);
			return managerId.get();   
		  } else {
			  throw new NotFoundException("No existe");  
		  }	
	}

	@Override
	@Transactional
	public void updateManager(Manager manager) {
		log.info("Producto: {}", manager);
		repository.save(manager);
		
	}

	@Override
	public void deleteManagerData(Long id) {
		try {
			repository.deleteById(id);
			}catch (NotFoundException e) {
			  log.debug("Error en el Id");
		      throw new  NotFoundException("Id inexistente");
			}catch (Exception e) {
			  log.debug("Error en la base de datos");
	          throw new  InternalError("Error en la base");
			}
		
	}

	@Override
	@Transactional
	public void createManager(Manager manager) {
		log.info("Manager: {}", manager);
		repository.save(manager);	
	}

	@Override
	public ResponseDataManager getResponseManager(RequestDataManager requestDataManager) {
		
		List<Manager> listManagers = getListManagers();
//		Set<Manager> setManagers= new HashSet<>();
		 
		listManagers = listManagers.stream().filter(dataManager -> dataManager.getName()
				.contains(requestDataManager.getNombre()))
				.collect(Collectors.toList());
		
		if(requestDataManager.getApellidoPaterno() != null && requestDataManager.getApellidoPaterno() != "") {
			listManagers = 	listManagers.stream().filter(dataManager -> dataManager.getLastnameFather()
					.contains(requestDataManager.getApellidoPaterno()))
					.collect(Collectors.toList());
		}
		
		if(requestDataManager.getApellidoMaterno() != null && requestDataManager.getApellidoMaterno() != "") {
			listManagers =  listManagers.stream().filter(dataManager -> dataManager.getLastnameMother()
				.contains(requestDataManager.getApellidoMaterno()))
			    .collect(Collectors.toList());
		}
		
		return new ResponseDataManager(!listManagers.isEmpty() ,listManagers);
	}
	

	
}
