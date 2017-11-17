package mx.com.mentoringit.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import mx.com.mentoringit.model.dto.BookDTO;
import mx.com.mentoringit.model.entities.Book;
import mx.com.mentoringit.model.interfaces.IBookDAO;

@Repository
public class BookDAO extends GenericDAO<Book> implements IBookDAO<Book> {

	@Override
	public List<BookDTO> findAll() throws Exception {

		List<Book> books = findAll(Book.class);

		List<BookDTO> booksDTO = new ArrayList<>();
		for (Book book : books) {
			BookDTO e = new BookDTO();
			BeanUtils.copyProperties(book, e);
			e.setImage(book.getBookImages().iterator().next().getFilename());
			booksDTO.add(e);
		}

		return booksDTO;
	}

	public BookDTO find(Integer idBook) throws Exception {


		Map<String, Integer> props = new HashMap<String, Integer>();
		props.put("bookId", idBook);
		
		Book book = super.find(Book.class, Restrictions.allEq(props));

		BookDTO bookDTO = new BookDTO();

		BeanUtils.copyProperties(book, bookDTO);
		bookDTO.setImage(book.getBookImages().iterator().next().getFilename());

		return bookDTO;

	}

}
