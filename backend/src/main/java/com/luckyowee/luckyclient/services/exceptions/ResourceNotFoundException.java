package com.luckyowee.luckyclient.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		//usando 'super' aqui ela repassa o argumento desta classe para a "super classe" services
		super(msg);
	}

}
