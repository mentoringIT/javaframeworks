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

	public String login() {
		String result="";
		if(name != null && !name.isEmpty()){
			result = "success";
		}else{
			result ="failure";
		}
		return result;
	}
	
	public String logout(){
		return "logout";
	}


}
