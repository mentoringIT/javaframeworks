package mx.com.mentoringit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mentoringit.model.dto.BookDTO;
import mx.com.mentoringit.model.entities.Book;
import mx.com.mentoringit.model.interfaces.IBookDAO;

@Service("bookService")
public class BookService {

	private List<BookDTO> books;

	@Autowired
	private IBookDAO<Book> bookDAO;


	@Transactional
	public List<BookDTO> getBooks() throws Exception {

		books = bookDAO.findAll();
		return books;
	}


	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
}
