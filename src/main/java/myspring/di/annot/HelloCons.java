package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("helloCons")
public class HelloCons {
	String name;
	Printer printer; // Printer 변수가 이렇게 존재함 (인터페이스 이름만 정해줌)
	List<String> names;

	public HelloCons() {
		System.out.println(this.getClass().getName()+" 생성자 호출");
	}

	@Autowired // 생성자위에서도 쓸 수 있음
	public HelloCons(@Value("annot생성자") String name, @Qualifier("consolePrinter") Printer printer) {
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
