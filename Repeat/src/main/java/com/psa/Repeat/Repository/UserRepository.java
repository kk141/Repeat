package com.psa.Repeat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.psa.Repeat.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query
	User findByEmail(String email);

}
