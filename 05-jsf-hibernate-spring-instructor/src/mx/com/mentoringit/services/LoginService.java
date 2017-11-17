package mx.com.mentoringit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mentoringit.model.dto.UsersDTO;
import mx.com.mentoringit.model.interfaces.ILoginDAO;


@Service("loginService")
public class LoginService {
	public LoginService() {
	}
	@Autowired
	private ILoginDAO loginDAO;
	
	@Transactional
	public UsersDTO login(UsersDTO login) throws Exception {
		return loginDAO.login(login);
	}
}
