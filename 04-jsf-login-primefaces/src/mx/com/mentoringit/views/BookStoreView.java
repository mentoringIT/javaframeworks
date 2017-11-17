package mx.com.mentoringit.views;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.com.mentoringit.model.dto.BookDTO;
import mx.com.mentoringit.services.BookService;

@ManagedBean
@ViewScoped
public class BookStoreView {

    @ManagedProperty("#{bookService}")
    private BookService bookService;
	
    private List<BookDTO> books;
    
    @PostConstruct
    public void init() {
        setBooks(bookService.createBooks(6));
    }

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
     
}
