package jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService 
public class HelloService {
	
	@WebMethod 
	public String getMessage() {
		return "Hello World!";
	}

}
