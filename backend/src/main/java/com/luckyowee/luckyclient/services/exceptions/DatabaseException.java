package com.luckyowee.luckyclient.services.exceptions;

public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		//usando 'super' aqui ela repassa o argumento desta classe para a "super classe" services
		super(msg);
	}

}
