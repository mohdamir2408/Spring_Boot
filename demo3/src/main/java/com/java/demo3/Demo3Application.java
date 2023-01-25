package com.java.demo3;

import com.java.demo3.dao.UserRepository;
import com.java.demo3.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;


@SpringBootApplication
public class Demo3Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Demo3Application.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);

		/* User user=new User();
		user.setFirst_name("Anil");
		user.setLast_name("Kumar");
		user.setEmail("anil0123@gmail.com");
		user.setAddress("Delhi");
		user.setPhone("9899786821");
		User user1 =userRepository.save(user);
		System.out.println(user1);

		 */

		//Create object of user

		/*User user3 = new User();
		user3.setFirst_name("Amit");
		user3.setLast_name("Kumar");
		user3.setEmail("amir0123@gmail.com");
		user3.setAddress("Noida");
		user3.setPhone("9784386821");

		User user2=new User();
		user2.setFirst_name("Sunil");
		user2.setLast_name("Kumar");
		user2.setEmail("Sunil0123@gmail.com");
		user2.setAddress("New Delhi");
		user2.setPhone("8979786821");

		User resultUser= userRepository.save(user2); //saving single user
		System.out.println("save user" +resultUser);

		 */


		// Update the use by Id

		Optional <User> optional = userRepository.findById(3);
		User user = optional.get();
		user.setFirst_name("Mohit");
		user.setLast_name("Saini");
		user.setEmail("mohit0123@gmail.com");
		user.setAddress("Noida");
		user.setPhone("9734340656");

		User result=userRepository.save(user);
		System.out.println(result);

		//Delete data by ID

		userRepository.deleteById(4);
		System.out.println("Deleted");



	}

}
