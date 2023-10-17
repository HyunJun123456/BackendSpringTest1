package myspring.di.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy2.dao.UserDao;
import myspring.di.strategy2.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-user-annot.xml")
public class Strategy2Test {
	@Autowired
	UserService userservice; // Hello라고 생각

	@Autowired
	UserDao userdao; // Printer라고 생각

	@Test
	void fetchUser() {
		assertEquals("gildong", userservice.getUser(0).getUserId());
		System.out.println(userdao.readAll());
	}

	@Test
	void fetchUsers() {
		assertEquals("gildong", userservice.getUserList().get(0).getUserId());
	}

}
