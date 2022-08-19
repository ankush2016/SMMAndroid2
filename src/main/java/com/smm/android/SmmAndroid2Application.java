package com.smm.android;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.smm.android.dao.UserRepository;
import com.smm.android.enitites.User;

@SpringBootApplication
public class SmmAndroid2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SmmAndroid2Application.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		// saveUser(userRepository);
		// updateUser(userRepository);
		// printAllUsers(userRepository);
		// deleteUsers(userRepository);
		//customFinderMethods(userRepository);
		//customJPQLAndNativeQueries(userRepository);
	}

	private static void customJPQLAndNativeQueries(UserRepository userRepository) {
		getUserByJPQL(userRepository);
		getUsersByNativeQuery(userRepository);
	}

	private static void getUsersByNativeQuery(UserRepository userRepository) {
		List<User> user = userRepository.getUsersByNativeQuery();
		user.forEach(usr -> {
			System.out.println(usr.getId() + ", " + usr.getName() + ", " + usr.getMetadata());
		});
		System.out.println("done");
	}

	private static void getUserByJPQL(UserRepository userRepository) {
		List<User> user = userRepository.getUserByNameAndCity("Ankush", "Lucknow");
		user.forEach(usr -> {
			System.out.println(usr.getId() + ", " + usr.getName() + ", " + usr.getMetadata());
		});
		System.out.println("done");
	}

	private static void customFinderMethods(UserRepository userRepository) {
		findByName(userRepository);
		findByNameAndCity(userRepository);
		findByNameStartingWith(userRepository);
	}

	private static void findByNameStartingWith(UserRepository userRepository) {
		List<User> user = userRepository.findByNameStartingWith("Arsh");
		user.forEach(usr -> {
			System.out.println(usr.getId() + ", " + usr.getName() + ", " + usr.getMetadata());
		});
		System.out.println("done");
	}

	private static void findByNameAndCity(UserRepository userRepository) {
		List<User> user = userRepository.findByNameAndCity("Ankush", "Lucknow");
		user.forEach(usr -> {
			System.out.println(usr.getId() + ", " + usr.getName() + ", " + usr.getMetadata());
		});
		System.out.println("done");
	}

	private static void findByName(UserRepository userRepository) {
		List<User> user = userRepository.findByName("Atul Kapoor");
		user.forEach(usr -> {
			System.out.println(usr.getId() + ", " + usr.getName() + ", " + usr.getMetadata());
		});
		System.out.println("done");
	}

	private static void deleteUsers(UserRepository userRepository) {
		// deleteUserById(userRepository);
		deleteAllUsers(userRepository);
	}

	private static void deleteAllUsers(UserRepository userRepository) {
		userRepository.deleteAll();
		System.out.println("All users deleted");
	}

	private static void deleteUserById(UserRepository userRepository) {
		userRepository.deleteById(5);
		System.out.println("user deleted");
	}

	private static void printAllUsers(UserRepository userRepository) {
		Iterable<User> itr = userRepository.findAll();
		itr.forEach(user -> {
			System.out.println(user.getName());
		});
	}

	private static void updateUser(UserRepository userRepository) {
		Optional<User> optional = userRepository.findById(4);
		User user = optional.get();
		user.setName("Ankush Kapoor");
		User result = userRepository.save(user);
		System.out.println(result);
	}

	private static void saveUser(UserRepository userRepository) {
//		User user1 = new User();
//		user1.setName("Ankush");
//		user1.setCity("Lucknow");
//		user1.setStatus("Android Developer");
//
//		User user2 = new User();
//		user2.setName("Atul Kapoor");
//		user2.setCity("Lucknow");
//		user2.setStatus("Banker");
//
//		User user3 = new User();
//		user3.setName("Arsh Kapoor");
//		user3.setCity("Lucknow");
//		user3.setStatus("Entrepreneur");
//
//		// To save single user
//		User resultUser = userRepository.save(user1);
//		System.out.println("User saved = " + resultUser.toString());
//
//		// To save multiple users
//		List<User> users = List.of(user2, user3);
//		Iterable<User> result = userRepository.saveAll(users);
//		result.forEach(user -> {
//			System.out.println(user);
//		});
	}

}