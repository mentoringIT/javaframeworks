package mx.com.mentoringit.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mentoringit.model.dto.BookDTO;
import mx.com.mentoringit.model.dto.LineItemDTO;
import mx.com.mentoringit.model.entities.Book;
import mx.com.mentoringit.model.interfaces.IBookDAO;
import mx.com.mentoringit.sesion.ShoppingCarBean;

@Service
public class ShoppingCartService {

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private IBookDAO<Book> bookDAO;

	
	public IBookDAO<Book> getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(IBookDAO<Book> bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Transactional
	public void addBookToCar(int bookId) throws Exception {
		Map<String, Integer> props = new HashMap<String, Integer>();
		props.put("bookId", bookId);

		BookDTO bookDTO = bookDAO.find(bookId);

		ShoppingCarBean shoppingCarBean = (ShoppingCarBean) appContext.getBean("shoppingCarBean");

		LineItemDTO bookLineItem = new LineItemDTO();
		bookLineItem.setBookDTO(bookDTO);
		
		if(shoppingCarBean.getLineItems().contains(bookLineItem)){
			for (Iterator<LineItemDTO> it = shoppingCarBean.getLineItems().iterator(); it.hasNext(); ) {
		        LineItemDTO f = it.next();
		        if (f.equals(bookLineItem))
		            f.setQuantity(f.getQuantity()+1);
		    }
			
		}else{
			LineItemDTO itemDTO = new LineItemDTO();
			itemDTO.setQuantity(1);
			itemDTO.setUnitPrice(bookDTO.getListPrice());
			itemDTO.setBookDTO(bookDTO);
			shoppingCarBean.getLineItems().add(itemDTO);
		}
		
		shoppingCarBean.updatePurchaseOrder();
		
	}

	public void removeBookFromCar(BookDTO book) {
		ShoppingCarBean shoppingCarBean = (ShoppingCarBean) appContext.getBean("shoppingCarBean");
		
		LineItemDTO item = new LineItemDTO();
		item.setBookDTO(book);
		shoppingCarBean.getLineItems().remove(item);
		
		shoppingCarBean.updatePurchaseOrder();
	}
	
	public void cleanCartShopping(){
		ShoppingCarBean shoppingCarBean = (ShoppingCarBean) appContext.getBean("shoppingCarBean");
		shoppingCarBean.setPurchaseOrderDTO(null);
		shoppingCarBean.setLineItems(null);
	}
}
