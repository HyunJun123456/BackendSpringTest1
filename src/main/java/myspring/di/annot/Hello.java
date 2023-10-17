package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("helloBean")
public class Hello {
	// 더이상 setter 메서드가 없어도 괜찮음
	@Value("어노테이션")
	String name;
	
	@Autowired
	@Qualifier("stringPrinter") // 안쓰면 오류남 (Printer 타입이 지금 2가지가 있어서)
	Printer printer; // Printer 변수가 이렇게 존재함 (인터페이스 이름만 정해줌)
	
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName()+" 생성자 호출");
	}

	public Hello(String name, Printer printer) {
		System.out.println(this.getClass().getName()+" 오버로딩된 생성자 호출");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		System.out.println("Hello setNames() "+ list);
		this.names = list;
	}


	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
