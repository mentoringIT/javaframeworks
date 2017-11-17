package mx.com.mentoringit.views;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import mx.com.mentoringit.model.dto.UsersDTO;
import mx.com.mentoringit.services.LoginService;

@Component("user")
@ViewScoped// tiempo que vive el bean en esa sesion en el cliente
				// (browser-dispositivo q invoca )
@Controller
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserBean() {
		userDTO = new UsersDTO();
	}

	@Autowired
	private LoginService loginService;
	
	private UsersDTO userDTO;

	public String login() {
		String result = "";
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (loginService.login(userDTO) == null) {

				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al autenticarse",
						"Usuario o password incorrecto"));
			} else {
				context.getExternalContext().getSessionMap().put("userLogged", true);
				result = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "logout";
	}
	public void toIndex() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void preRenderView() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		if (!(request.getRequestedSessionId() != null && request.getSession(false) != null && request.getSession(false).getAttribute("userLogged") != null)) {
			toIndex();
		}
	}

	public UsersDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UsersDTO userDTO) {
		this.userDTO = userDTO;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
