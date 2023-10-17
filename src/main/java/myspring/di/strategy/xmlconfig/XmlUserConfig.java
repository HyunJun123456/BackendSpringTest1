package myspring.di.strategy.xmlconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.strategy3.dao.UserDao;
import myspring.di.strategy3.dao.UserDaoImpl;
import myspring.di.strategy3.service.UserService;
import myspring.di.strategy3.service.UserServiceImpl;

@Configuration
public class XmlUserConfig {
	@Bean
	UserService userservice() {
		return new UserServiceImpl();
	}
	
	@Bean
	UserDao userdao() {
		return new UserDaoImpl();
	}
}
