package com.manager.micro.data.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class RequestDataManager implements Serializable {
	
	@NotNull
	@NotEmpty
	private String nombre;
	
	
	private String apellidoPaterno;
	
	
	private String apellidoMaterno;
	
	private static final long serialVersionUID = -7748434981757383149L;
	

}
