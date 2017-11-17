package mx.com.mentoringit.views;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import mx.com.mentoringit.model.dto.BookDTO;
import mx.com.mentoringit.model.dto.LineItemDTO;
import mx.com.mentoringit.model.dto.PurchaseOrderDTO;
import mx.com.mentoringit.services.BookService;
import mx.com.mentoringit.services.PurchaseOrderService;
import mx.com.mentoringit.services.ShoppingCartService;
import mx.com.mentoringit.sesion.ShoppingCarBean;

@Component("carDetailView")
@ViewScoped
public class CarDetailView {
	/**
	 * 
	 */
	private List<LineItemDTO> carShopping;

	@Autowired
	private BookService bookService;

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private ApplicationContext appContext;


	@PostConstruct
	public void init() {
	}

	public String viewDetail() {
		return "detail";
	}

	public String continuaComprando() {
		return "bookstore";
	}

	public void saveOrder() {
		
		PurchaseOrderDTO orderDTO = getPurchaseOrderDTO();
		
		try {
			if(purchaseOrderService.saveOrder(orderDTO)){
				addMessage("Aviso", "Tus productos están en camino!");
				shoppingCartService.cleanCartShopping();
			}else{
				addMessage("Aviso", "Ocurrio un error, intentelo más tarde!");			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public void removeBookFromCar(BookDTO book) {
		shoppingCartService.removeBookFromCar(book);
	}

	public List<LineItemDTO> getCarShopping() {
		ShoppingCarBean shoppingCarBean = (ShoppingCarBean) appContext.getBean("shoppingCarBean");

		setCarShopping(new ArrayList<>(shoppingCarBean.getLineItems()));
		return carShopping;
	}

	public void setCarShopping(List<LineItemDTO> carShopping) {
		this.carShopping = carShopping;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public PurchaseOrderDTO getPurchaseOrderDTO() {
		ShoppingCarBean shoppingCarBean = (ShoppingCarBean) appContext.getBean("shoppingCarBean");
		return shoppingCarBean.getPurchaseOrderDTO();
	}
}
