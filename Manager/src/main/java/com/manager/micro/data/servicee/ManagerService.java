package com.manager.micro.data.servicee;

import java.util.List;

import com.manager.micro.data.model.Manager;
import com.manager.micro.data.model.RequestDataManager;
import com.manager.micro.data.model.ResponseDataManager;

public interface ManagerService {
	
	public List<Manager> getListManagers();
	
	public Manager getManagerById(Long id);
	
	public void updateManager(Manager manager);
	
	public void deleteManagerData(Long id);
	
	public void createManager(Manager manager);
	
	public ResponseDataManager getResponseManager(RequestDataManager requestDataManager);
	
	
	


	
}
