package mx.com.mentoringit.model.dto;
// Generated 7/10/2017 06:48:09 AM by Hibernate Tools 4.0.1.Final

import java.util.Date;

/**
 * Users generated by hbm2java
 */
public class UsersDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int enabled;
	private String fullName;
	private String email;
	private Date created;
	private Date dayOfBirth;
	private String gender;
	// private Set<PurchaseOrder> purchaseOrders = new
	// HashSet<PurchaseOrder>(0);
	// private Authorities authorities;
	// private Set<Address> addresses = new HashSet<Address>(0);

	public UsersDTO() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getDayOfBirth() {
		return this.dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}