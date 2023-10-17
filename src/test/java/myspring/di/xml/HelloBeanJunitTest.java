package myspring.di.xml;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	BeanFactory factory;

	@BeforeEach
	void init() {
		// 1. Spring Bean Container 객체생성
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml"); // xml에 위치를 알려줘야함

	}
	
	@Test
	void helloCon() { // 자바는 유니코드라 한글도 지원함 (메서드 네임에서)
		Hello bean = factory.getBean("helloC", Hello.class);
		assertEquals("Hello 생성자", bean.sayHello());
		bean.print();
		
		List<String> names = bean.getNames();
		
		assertEquals(3, names.size());
		assertEquals("SpringBoot", names.get(1));
		
	}
	
	

	@Test
	@Disabled // 일시적으로 실행 안되게 해줌
	void hello() {
		// 2. Container가 생성한 Bean을 요청하기
		// 객체를 직접 생성하지 않고 내부적으로 맡김 (싱글톤이든 다양하게 내부적으로 처리해주기 때문에)
		// Hello hello = new Hello(); 보통같으면 이렇게 하는데 객체 생성을 위임함
		Hello hello1 = (Hello) factory.getBean("hello"); // 다운 캐스팅 필요
		Hello hello2 = factory.getBean("hello", Hello.class);
		// System.out.println(hello1 == hello2);
		// prototype은 객체를 항상 생성함
		assertSame(hello1, hello2); // 객체의 주소를 비교하게 됨
		assertEquals("Hello 스프링", hello2.sayHello()); // 값 비교
		hello2.print();
		
		// 다형성
		Printer printer = factory.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());

	}
	
	
}
