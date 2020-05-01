package com.mattaldrete.xtrails.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattaldrete.enitities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByIdAndEnabledTrue(Integer id);

}
