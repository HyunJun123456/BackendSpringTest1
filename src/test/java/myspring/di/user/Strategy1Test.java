package myspring.di.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-user.xml")
public class Strategy1Test {
	@Autowired
	UserService userService; // Hello라고 생각
	
	@Autowired
	UserDao userDao; // Printer라고 생각
	
	@Test
	void fetchUser() {
		assertEquals("gildong", userService.getUser(0).getUserId());
		System.out.println(userDao.readAll());
	}
	
	@Test
	void fetchUsers() {
		assertEquals("gildong", userService.getUserList().get(0).getUserId());
	}
	
}
