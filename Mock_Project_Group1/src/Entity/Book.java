package Entity;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookID;
	private String bookTitle;
	private String author;
	private String brief;
	private String publisher;
	private String content;
	private String category;


	public Book() {
		super();
	}

	public Book(int bookID, String bookTitle, String author, String brief, String publisher, String content,
			String category) {
		super();
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.author = author;
		this.brief = brief;
		this.publisher = publisher;
		this.content = content;
		this.category = category;
	}



	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		String format = String.format("%1$5s %2$20s %3$20s %4$15s  %5$20s",
				bookID, bookTitle, author, category, publisher);
		return format;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + bookID;
		
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
		Book other = (Book) obj;
		
		if (bookID != other.bookID)
			return false;
		
		return true;
	}
	
}
