package myspring.di.xml;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserService;
import myspring.user.vo.UserVO;

public class UserBeanJunitTest {
	BeanFactory factory;

	@BeforeEach
	void init() {
		// 1. Spring Bean Container 객체생성
		factory = new GenericXmlApplicationContext("classpath:spring-beans-user.xml"); // xml에 위치를 알려줘야함

	}

	@Test
	@Disabled
	void userCon() { // 자바는 유니코드라 한글도 지원함 (메서드 네임에서)
		UserService userservice = factory.getBean("userService", UserService.class);
		assertEquals("gildong", userservice.getUser(0).getUserId());
		List<UserVO> lists = userservice.getUserList();
		assertEquals(2, lists.size());
	}

	@Test
	// @Disabled // 일시적으로 실행 안되게 해줌
	void user() {

		UserService userservice1 = factory.getBean("userService", UserService.class);
		UserService userservice2 = (UserService) factory.getBean("userService");
		assertSame(userservice1, userservice2);

		UserDao userDao = factory.getBean("userDao", UserDao.class);
		System.out.println(userDao.readAll());
	}

}
