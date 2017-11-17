package mx.com.mentoringit.model.interfaces;

import java.util.List;

import mx.com.mentoringit.model.dto.BookDTO;

public interface IBookDAO<T> {

	public List<BookDTO> findAll() throws Exception;

	public BookDTO find(Integer idBook) throws Exception;


}
