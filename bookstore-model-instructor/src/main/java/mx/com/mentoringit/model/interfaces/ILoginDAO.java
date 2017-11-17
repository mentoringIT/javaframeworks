package mx.com.mentoringit.model.interfaces;

import mx.com.mentoringit.model.dto.UsersDTO;

public interface ILoginDAO {

	public UsersDTO login(UsersDTO login) throws Exception;
}
