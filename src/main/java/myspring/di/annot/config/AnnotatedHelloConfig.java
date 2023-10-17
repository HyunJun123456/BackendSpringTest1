package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 역할을 하는 클래스를 알려줌
@ComponentScan(basePackages = { "myspring.di.annot" })
public class AnnotatedHelloConfig {
	
}
