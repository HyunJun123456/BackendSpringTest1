package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.annot.HelloCons;

// @ExtendWith를 사용하므로 Container 객체를 만들지 않아도 자동으로 만들어줌
@ExtendWith(SpringExtension.class)
// xml에 위치를 정해주면 됨
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
	// 의존 받고 싶은 타입의 변수를 선언
	// getBean을 이제 사용하지 않아도 됨
	// Hello라는 Bean을 먼저 찾고 id도 비교하는듯
	// 그래서 이런경우 명명을 잘못하게 되면 Hello에대한 Bean이 2개여서 못찾아오게 됨
	// 없으면 null포인터 에러가 남
	@Autowired // Hello를 찾아서 자동으로 연결해주세요
	Hello hello;

	@Autowired
	@Qualifier("helloC")
	Hello hello2;
	
	@Resource(name = "helloC") // id로 얻어옴
	Hello hello3;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Test
	void hello() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", printer.toString());
		
	}
	
	@Test
	@Disabled
	void helloC() {
		assertEquals("Hello 생성자", hello2.sayHello());
		assertEquals("Hello 생성자", hello3.sayHello());
	}
	
	
	
}
