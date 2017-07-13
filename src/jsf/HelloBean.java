package jsf;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}
	public HelloBean() {
		System.out.println("HelloBean()");
	}
	// property message
	public String getMessage() {
		System.out.println("getMessage()");
		return "Hello JSF";
	}

	// property today
	public String getToday() {
		return LocalDateTime.now().toString();
	}
	
	public String process() {
		System.out.println("processing name : " + name);
		return null;
	}
}
