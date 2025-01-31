package org.jsp.userapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component   // To make this class as bean class and we can use autowired (for autowired object the clas should be bean class)
public class UserService {
	
	@Autowired
	private UserDao dao;

	public ResponseStructure<User> saveUser(User user) {
		   ResponseStructure<User> rs = new ResponseStructure<>();
		   user = dao.saveUser(user);    //User dbuser =dao.saveUser(user); 
		   rs.setStatus(200);
		   rs.setMessange("User Saved Successfully");
		   rs.setBody(user);
		   return rs;
	}

	public ResponseStructure<List<User>> findAllUsers() {
		List<User> allUsers = dao.findAllUsers();
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		
		if(allUsers.isEmpty()) {
//			structure.setStatus(404);
//			structure.setMessange("No User Present in Database Table...");
//			structure.setBody(allUsers);\
			throw new NoUserFoundException("No User Present in Database Table...");
		}
		else {
			structure.setStatus(200);
			structure.setMessange("All Users Found Successfully...");
			structure.setBody(allUsers);
		}
			return structure;
	}

	public ResponseStructure<User> findUserById(int id) {
		Optional<User> optional =  dao.findUserById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if(optional.isPresent()) {
			structure.setStatus(200);
			structure.setMessange("user found successfully");
			structure.setBody(optional.get());
			
		}
		else if(optional.isEmpty()){
//			structure.setStatus(404);
//			structure.setMessange("Invalid User Id");
//			structure.setBody(null);
			throw new InvalidUserId("Invalid User Id");
		}
		return structure;
	}

	public ResponseStructure<String> deleteUserById(int id) {
		Optional<User> user =  dao.findUserById(id);
		ResponseStructure<String> rs = new ResponseStructure<>();
		if(user.isPresent()) {
			dao.deleteUserById(id);
			rs.setStatus(200);
			rs.setMessange("User found and deleted");
			rs.setBody("User Deleted Successfully");
		}
		else {
//			rs.setStatus(400);
//			rs.setMessange("Invalid User ID...User not found");
//			rs.setBody("Bad Request");
			throw new InvalidUserId("Invalid User Id.....");
		}
		return rs;
	}

	public ResponseStructure<List<User>> findAllByStatus(String status) {
		List<User> users = dao.findAllByStatus(UserStatus.valueOf(status.toUpperCase()));
		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		
		if(users.isEmpty()) {
//			rs.setStatus(404);
//			rs.setMessange("No "+status.toUpperCase()+" Users found in database table");
//			rs.setBody(users);
			throw new NoUserFoundException("No User Present in Database Table...");
		}
		else {
			rs.setStatus(200);
			rs.setMessange("All "+status.toUpperCase()+" Users found successfully");
			rs.setBody(users);
		}
		
		return rs;
	}
	
}
