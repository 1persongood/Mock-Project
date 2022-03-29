package Entity;

import java.io.Serializable;

public class BookCase implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookCaseID;
	private String bookCaseName;

	public int getBookCaseID() {
		return bookCaseID;
	}

	public void setBookCaseID(int bookCaseID) {
		this.bookCaseID = bookCaseID;
	}

	public String getBookCaseName() {
		return bookCaseName;
	}

	public void setBookCaseName(String bookCaseName) {
		this.bookCaseName = bookCaseName;
	}

	public BookCase(int bookCaseID, String bookCaseName) {
		super();
		this.bookCaseID = bookCaseID;
		this.bookCaseName = bookCaseName;
	}

	public BookCase() {
		super();
	}

}
