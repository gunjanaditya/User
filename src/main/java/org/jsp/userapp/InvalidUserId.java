package org.jsp.userapp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InvalidUserId extends RuntimeException {
private String message =  "No message Available";
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
