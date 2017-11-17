package mx.com.mentoringit.model.dto;

public class BookImageDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bookImageId;
	private String filename;

	public BookImageDTO() {
	}

	public Integer getBookImageId() {
		return this.bookImageId;
	}

	public void setBookImageId(Integer bookImageId) {
		this.bookImageId = bookImageId;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
