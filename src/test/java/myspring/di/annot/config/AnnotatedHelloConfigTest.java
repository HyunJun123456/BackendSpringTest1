package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.Hello;

@ExtendWith(SpringExtension.class)
// bean 컨테이너가 달라서 loader를 추가해줘야함
@ContextConfiguration(classes = AnnotatedHelloConfig.class, loader = AnnotationConfigContextLoader.class)
public class AnnotatedHelloConfigTest {
	@Autowired
	Hello hello;
	
	@Test
	void hello() {
		System.out.println(hello.sayHello());
	}
	
}
