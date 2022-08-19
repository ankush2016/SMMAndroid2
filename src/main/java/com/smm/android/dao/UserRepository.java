package com.smm.android.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.smm.android.enitites.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);

	public List<User> findByNameAndCity(String name, String city);

	public List<User> findByNameStartingWith(String name);

	@Query("select u From User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n") String name);

	@Query("select u From User u WHERE u.name =:n and u.city =:c")
	public List<User> getUserByNameAndCity(@Param("n") String name, @Param("c") String city);

	@Query(value = "SELECT * FROM user", nativeQuery = true)
	public List<User> getUsersByNativeQuery();
}
