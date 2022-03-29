package Entity;

import java.io.Serializable;

public class Contain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookCaseID;
	private int bookID;
	private String createDate;

	public Contain() {
		super();
	}

	public Contain(int bookCaseID, int bookID, String createDate) {
		super();
		this.bookCaseID = bookCaseID;
		this.bookID = bookID;
		this.createDate = createDate;
	}

	public int getBookCaseID() {
		return bookCaseID;
	}

	public void setBookCaseID(int bookCaseID) {
		this.bookCaseID = bookCaseID;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
