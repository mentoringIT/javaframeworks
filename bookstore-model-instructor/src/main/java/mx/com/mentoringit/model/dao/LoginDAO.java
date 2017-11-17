package mx.com.mentoringit.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.mentoringit.model.dto.UsersDTO;
import mx.com.mentoringit.model.entities.Users;
import mx.com.mentoringit.model.interfaces.ILoginDAO;

@Repository("loginDAO")
public class LoginDAO extends GenericDAO<Users> implements ILoginDAO {

	public LoginDAO() {
	}

	public UsersDTO login(UsersDTO login) throws Exception {

		Map<String, String> props = new HashMap<String, String>();
		props.put("username", login.getUsername());
		props.put("password", login.getPassword());

		Users pojo = find(Users.class, Restrictions.allEq(props));

		UsersDTO userDTO=null;
		
		if(pojo != null){			
			userDTO= new UsersDTO();
			userDTO.setFullName(pojo.getFullName());
		}

		return userDTO;
	}

}