package mx.com.mentoringit.model.dto;

import java.io.Serializable;

public class LineItemDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer lineItemId;
	private BookDTO bookDTO;
	private PurchaseOrderDTO purchaseOrderDTO;
	private int quantity;
	private float unitPrice;

	public Integer getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(Integer lineItemId) {
		this.lineItemId = lineItemId;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnitPrice() {
		unitPrice =  quantity * bookDTO.getListPrice();
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BookDTO getBookDTO() {
		return bookDTO;
	}

	public void setBookDTO(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookDTO == null) ? 0 : bookDTO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineItemDTO other = (LineItemDTO) obj;
		if (bookDTO == null) {
			if (other.bookDTO != null)
				return false;
		} else if (!bookDTO.equals(other.bookDTO))
			return false;
		return true;
	}

	public PurchaseOrderDTO getPurchaseOrderDTO() {
		return purchaseOrderDTO;
	}

	public void setPurchaseOrderDTO(PurchaseOrderDTO purchaseOrderDTO) {
		this.purchaseOrderDTO = purchaseOrderDTO;
	}
}
