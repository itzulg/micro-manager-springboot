package com.manager.micro.data.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDataManager implements Serializable{

  private boolean flagData;
  
  private List<Manager> listManagers;

	private static final long serialVersionUID = 4880856352572996032L;

}
