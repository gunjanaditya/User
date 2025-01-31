package org.jsp.userapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	//jpa repo is alreday a component and we are extending to that so its not nessesory to give component annotation 
	//and for interfaces componenet is not recommended or uses
	//so here userrepository is a component only
	//for custom method(any method with out findBy prefix) query is nessesory 
	
	@Query("select u from User u where u.status='ACTIVE'")
	List<User> findAllActiveUsers();

	@Query("select u from User u where u.status='IN_ACTIVE'")
	List<User> findAllInActiveUsers();

	@Query("select u from User u where u.status='BLOCKED'")
	List<User> findAllBlockedUsers();

	List<User> findByStatus(UserStatus status);

}
