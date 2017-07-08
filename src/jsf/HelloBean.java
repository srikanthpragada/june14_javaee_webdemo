package jsf;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {

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
}
