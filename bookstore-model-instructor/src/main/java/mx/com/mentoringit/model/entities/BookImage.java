package mx.com.mentoringit.model.entities;
// Generated 7/10/2017 06:48:09 AM by Hibernate Tools 4.0.1.Final

/**
 * BookImage generated by hbm2java
 */
public class BookImage implements java.io.Serializable {

	private Integer bookImageId;
	private Book book;
	private String filename;

	public BookImage() {
	}

	public BookImage(Book book, String filename) {
		this.book = book;
		this.filename = filename;
	}

	public Integer getBookImageId() {
		return this.bookImageId;
	}

	public void setBookImageId(Integer bookImageId) {
		this.bookImageId = bookImageId;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}