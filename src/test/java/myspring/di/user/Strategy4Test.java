package myspring.di.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import myspring.di.strategy.annot.config.AnnotatedUserConfig;
import myspring.di.strategy.xmlconfig.XmlUserConfig;
import myspring.di.strategy3.dao.UserDao;
import myspring.di.strategy3.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = XmlUserConfig.class)
public class Strategy4Test {
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
