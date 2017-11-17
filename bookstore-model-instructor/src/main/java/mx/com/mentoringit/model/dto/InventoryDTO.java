package mx.com.mentoringit.model.dto;

import java.io.Serializable;

public class InventoryDTO implements Serializable{
	private Integer bookId;
	private int bookQuantity;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
}
