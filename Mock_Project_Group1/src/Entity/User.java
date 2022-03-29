package Entity;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String password;
	private int bookCaseID;
	private int roleID;

	public User() {
	}

	public User(int id, String userName, String password, int bookCaseID, int roleID) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.bookCaseID = bookCaseID;
		this.roleID = roleID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBookCaseID() {
		return bookCaseID;
	}

	public void setBookCaseID(int bookCaseID) {
		this.bookCaseID = bookCaseID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

}
