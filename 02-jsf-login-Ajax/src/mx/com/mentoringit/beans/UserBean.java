package mx.com.mentoringit.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "user")
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name="";
	private String password="";
	private String greeting;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGreeting() {
		
		if(name.length()==0){
			greeting = "";
		}else{
			greeting = "Welcome to JSF2 + Ajax, " + name + "!";
		}
		return greeting;
	}


}
