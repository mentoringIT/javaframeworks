package mx.com.mentoringit.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mentoringit.model.dto.BookDTO;
import mx.com.mentoringit.services.BookService;
import mx.com.mentoringit.services.ShoppingCartService;

@Component("bookStoreView")
@ViewScoped
@Scope("session")
public class BookStoreView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// busca un bean llamado bookService en memoria, y lo inyecta
	// utilizando el setter de bookService
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	private List<BookDTO> books;

	@PostConstruct
	public void init() {
		try {
			books = bookService.getBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addItemToCar(int bookId) {
		try {
			shoppingCartService.addBookToCar(bookId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestContext context = RequestContext.getCurrentInstance();
		context.update("cartQuantity");
		
		return false;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
}