package org.jsp.userapp;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseStructure<String> noUserFoundexception(NoUserFoundException e){
		ResponseStructure<String> str = new ResponseStructure<>(404,"No User Found",e.getMessage());
		return str;
	}
	
	@ExceptionHandler(InvalidUserId.class)
	public ResponseStructure<String> invalidUserId(InvalidUserId e){
		ResponseStructure<String> str = new ResponseStructure<>(404,"Invalid User id...",e.getMessage());
		return str;
	}
}
