package mx.com.mentoringit.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PurchaseOrderDTO {

	private Integer purchaseOrderId;
	// private Address addressByShipToAddressId;
	// private Address addressByBillToAddressId;
	private UsersDTO users;
	private Date orderDate;
	private float totalPrice;
	private Set<LineItemDTO> lineItemsDTO = new HashSet<LineItemDTO>(0);

	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public UsersDTO getUsers() {
		return users;
	}

	public void setUsers(UsersDTO users) {
		this.users = users;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalPrice() {
		totalPrice = 0;
		for (LineItemDTO lineItemDTO : lineItemsDTO) {
			totalPrice += lineItemDTO.getUnitPrice();
		}
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<LineItemDTO> getLineItemsDTO() {
		return lineItemsDTO;
	}

	public void setLineItemsDTO(Set<LineItemDTO> lineItems) {
		this.lineItemsDTO = lineItems;
	}
}
