package mx.com.mentoringit.services;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mentoringit.model.dto.PurchaseOrderDTO;
import mx.com.mentoringit.model.entities.Address;
import mx.com.mentoringit.model.entities.LineItem;
import mx.com.mentoringit.model.entities.PurchaseOrder;
import mx.com.mentoringit.model.entities.Users;
import mx.com.mentoringit.model.interfaces.IPurchaseOrder;
import mx.com.mentoringit.sesion.ShoppingCarBean;

@Service("purchaseOrderService")
public class PurchaseOrderService {

	@Autowired
	private IPurchaseOrder<PurchaseOrder> purchaseOrderDAO;

	@Autowired
	private ApplicationContext appContext;
	
	@Transactional
	public boolean saveOrder(PurchaseOrderDTO orderDTO) throws Exception {

		PurchaseOrder order = new PurchaseOrder();
		
		BeanUtils.copyProperties(orderDTO, order);
		Address address = new Address();
		address.setAddressId(1);

		Users user = new Users();
		user.setUsername("mangelg");
		
		Date orderDate = new Date();
		order.setAddressByBillToAddressId(address);
		order.setAddressByShipToAddressId(address);
		order.setUsers(user);
		order.setOrderDate(orderDate);

		for (LineItem item: order.getLineItems()) {
			item.setPurchaseOrder(order);
		}
		
		purchaseOrderDAO.saveOrUpdate(order);

		PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();

		BeanUtils.copyProperties(order, purchaseOrderDTO);
		
		ShoppingCarBean shoppingCarBean = (ShoppingCarBean) appContext.getBean("shoppingCarBean");
		shoppingCarBean.setLastPurchaseOrderDTO(purchaseOrderDTO);
		
		return true;
	}
}
