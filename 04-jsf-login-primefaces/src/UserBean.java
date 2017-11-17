import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "user")
@SessionScoped // tiempo que vive el bean en esa sesion en el cliente
				// (browser-dispositivo q invoca )
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String user;
	private String password;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public String login() {
		String result = "";
		if ((user == null || password == null) || (user.length() == 0 || password.length() == 0)) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Error al autenticarse", "Usuario o password incorrecto"));
		} else {
			result = "success";
		}
		return result;
	}

	public String logout() {
		return "logout";
	}
	
	public void toIndex(){
			 try {
				FacesContext.getCurrentInstance().getExternalContext()
				         .redirect("faces/index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
