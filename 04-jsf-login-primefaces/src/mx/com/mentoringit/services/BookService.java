package mx.com.mentoringit.services;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import mx.com.mentoringit.model.dto.BookDTO;


@ManagedBean(name = "bookService")
@ApplicationScoped
public class BookService {

	public List<BookDTO> createBooks(int i) {
		return null;
	}

}