package mx.com.mentoringit.sesion;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mentoringit.model.dto.LineItemDTO;
import mx.com.mentoringit.model.dto.PurchaseOrderDTO;

@Component
@Scope("session")
public class ShoppingCarBean implements Serializable {

	private Set<LineItemDTO> lineItems = new HashSet<LineItemDTO>();
	private PurchaseOrderDTO purchaseOrderDTO;
	private PurchaseOrderDTO lastPurchaseOrderDTO;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PurchaseOrderDTO getPurchaseOrderDTO() {
		return purchaseOrderDTO;
	}

	public void setPurchaseOrderDTO(PurchaseOrderDTO purchaseOrderDTO) {
		this.purchaseOrderDTO = purchaseOrderDTO;
	}

	public void updatePurchaseOrder() {
		float totalPrice = 0;

		if (purchaseOrderDTO == null) {
			purchaseOrderDTO = new PurchaseOrderDTO();
			purchaseOrderDTO.setLineItemsDTO(lineItems);
			for (Iterator<LineItemDTO> iterator = lineItems.iterator(); iterator.hasNext();) {
				LineItemDTO lineItemDTO = iterator.next();
				totalPrice += lineItemDTO.getUnitPrice();
			}

		} else {
			for (LineItemDTO lineItemDTO : lineItems) {
				totalPrice += lineItemDTO.getUnitPrice();
			}
		}
		purchaseOrderDTO.setTotalPrice(totalPrice);
	}

	public Set<LineItemDTO> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItemDTO> lineItems) {
		if (lineItems == null) {
			this.lineItems = new HashSet<LineItemDTO>();
		} else {
			this.lineItems = lineItems;
		}
	}

	public PurchaseOrderDTO getLastPurchaseOrderDTO() {
		return lastPurchaseOrderDTO;
	}

	public void setLastPurchaseOrderDTO(PurchaseOrderDTO lastPurchaseOrderDTO) {
		this.lastPurchaseOrderDTO = lastPurchaseOrderDTO;
	}

}