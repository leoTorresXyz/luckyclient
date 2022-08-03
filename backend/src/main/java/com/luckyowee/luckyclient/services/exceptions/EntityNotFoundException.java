package com.luckyowee.luckyclient.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String msg) {
		//usando 'super' aqui ela repassa o argumento desta classe para a "super classe" services
		super(msg);
	}

}
