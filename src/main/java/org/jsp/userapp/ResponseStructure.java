package org.jsp.userapp;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Data --> we will not prefer this because we dont want implementation foer to String and hashcode methods
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {        //T -> type class that decide the type of member at runtime ex. type of body -> String,user object,list
	
	private int status;
	private String messange;
	private T body;
}
