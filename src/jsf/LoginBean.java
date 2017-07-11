package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
public class LoginBean {

	private String username, password, message;
	
	@NotNull ( message="Username must be entered!") 
	@Pattern(regexp="[a-zA-Z]{4,10}", message ="Must be 4 to 10 chars only")
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull ( message="Password must be entered!") 
	@Size(min=4, max=10, message="Password must be 4 to 10 chars")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	// Action controller 
	public String login() {
		if ( username.startsWith("a") && password.equals("admin"))
		{
 			  // store name in session
			  HttpSession session = (HttpSession) 
				   FacesContext.getCurrentInstance()
			      .getExternalContext().getSession(true);
			  session.setAttribute("username",username);
			  return "home";  // home.xhtml
		}
		else 
		{
			  message  = "Sorry! Invalid Login!";
			  return "login";
		}
	}

}
