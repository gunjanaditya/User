package org.jsp.userapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	@Autowired
	private UserRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public List<User> findAllUsers() {
		return repo.findAll();
	}

	public Optional<User> findUserById(int id) {
		return repo.findById(id);
	}

	public void deleteUserById(int id) {
		repo.deleteById(id);
	}

	public List<User> findAllByStatus(UserStatus userStatus) {
		return repo.findByStatus(userStatus);
	}

	
}
