package com.tnp.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotfoundException extends RuntimeException{
	
	public static final long serialVersionUID=1L;
	public ResourceNotfoundException(String msg)
	{
		super(msg);
	}

}
