package rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class Hello {

	  @GET
	  public String get() {
		  return "Hello from Jersey. Today is " + new Date().toString();
	  }
}
