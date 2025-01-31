package org.jsp.userapp;

import java.util.List;

//NOTE:- by default browser can send Get Type Request Only

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		//return repository.save(user);
		return service.saveUser(user);
	}
	@GetMapping
	public ResponseStructure<List<User>> findAllUsers(){
		return service.findAllUsers();
	}
	@GetMapping("/{id}")
	public ResponseStructure<User> findUserByid(@PathVariable int id) {
		return service.findUserById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseStructure<String> deleteUserById(@PathVariable int id) {
		//optional object (it is a wraper object ) is used to avoid null pointer exception that we get commenly in springboot
//		Optional<User> optional = repository.findById(id);
//		if(optional.isPresent()) {
//			repository.deleteById(id);
//			return "";
//		}
//		else {
//			return "Invalid User Id Unable to Delete...";
//		}
		return service.deleteUserById(id);
	}

	@GetMapping("/status/{status}")
	public ResponseStructure<List<User>> findAllByStatus(@PathVariable String status){
		//List<User> UserByStatus =  repository.findByStatus(UserStatus.valueOf(status.toUpperCase()));       // UserStatus.valueof(status) -> if we excepting String type of status
		return service.findAllByStatus(status);
	}
	
	
	
	
	
	
	
	
	
	//THINGS TO REMBEMBER----
	//NOT FOUND -> 404
	//SUCCESSS "OK" -> 200
	// BAD REQUEST -> 400
	//200-299 -> SUCESS
	//300-399 -> CLIENT SIDE
	//400-499 -> NOT FOUND
	//500- 599 -> SERVER SIDE ERROR
	
	
//	@GetMapping("/active")
//	public List<User> findAllActiveUsers(){
//		List<User> activeUsers =  repository.findAllActiveUsers();
//		return activeUsers;
//	}
//	
//	@GetMapping("/inactive")
//	public List<User> findAllInActiveUsers(){
//		List<User> InActiveUsers =  repository.findAllInActiveUsers();
//		return InActiveUsers;
//	}
//	
//	@GetMapping("/blocked")
//	public List<User> findAllBlockedUsers(){
//		List<User> blockedUsers =  repository.findAllBlockedUsers();
//		return blockedUsers;
//	}
	
}
