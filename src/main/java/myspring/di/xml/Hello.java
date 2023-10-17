package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
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

	public void setName(String name) {
		System.out.println("Hello setName() "+name);
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		System.out.println("Hello setPrinter() "+printer.getClass().getName());
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
