package mx.com.mentoringit.model.dto;

import java.util.HashSet;
import java.util.Set;

import mx.com.mentoringit.model.entities.Inventory;

public class BookDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer bookId;
	// private Category category;
	private String title;
	private String description;
	private float listPrice;
	private String listPriceCurrency;
	private Float paperback;
	private String publisher;
	private String language;
	private String isbn10Integer;
	private String isbn13Integer;
	private String image;
	private Set<BookImageDTO> bookImages = new HashSet<>();
	 private InventoryDTO inventoryDTO = new InventoryDTO();
	// private Set<LineItem> lineItems = new HashSet<LineItem>(0);
	// private Set<Author> authors = new HashSet<Author>(0);

	public BookDTO() {
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(float listPrice) {
		this.listPrice = listPrice;
	}

	public String getListPriceCurrency() {
		return this.listPriceCurrency;
	}

	public void setListPriceCurrency(String listPriceCurrency) {
		this.listPriceCurrency = listPriceCurrency;
	}

	public Float getPaperback() {
		return this.paperback;
	}

	public void setPaperback(Float paperback) {
		this.paperback = paperback;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsbn10Integer() {
		return this.isbn10Integer;
	}

	public void setIsbn10Integer(String isbn10Integer) {
		this.isbn10Integer = isbn10Integer;
	}

	public String getIsbn13Integer() {
		return this.isbn13Integer;
	}

	public void setIsbn13Integer(String isbn13Integer) {
		this.isbn13Integer = isbn13Integer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<BookImageDTO> getBookImages() {
		return bookImages;
	}

	public void setBookImages(Set<BookImageDTO> bookImages) {
		this.bookImages = bookImages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((isbn10Integer == null) ? 0 : isbn10Integer.hashCode());
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
		BookDTO other = (BookDTO) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (isbn10Integer == null) {
			if (other.isbn10Integer != null)
				return false;
		} else if (!isbn10Integer.equals(other.isbn10Integer))
			return false;
		return true;
	}

	public InventoryDTO getInventoryDTO() {
		return inventoryDTO;
	}

	public void setInventoryDTO(InventoryDTO inventoryDTO) {
		this.inventoryDTO = inventoryDTO;
	}


}
