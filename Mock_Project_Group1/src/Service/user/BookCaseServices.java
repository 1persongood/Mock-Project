package Service.user;

import java.util.ArrayList;

import Entity.Book;
import Entity.Contain;
import Util.Constant;
import Util.ReadWriteFile;
import Util.Validator;

public class BookCaseServices {

	int bookCaseID;
	ArrayList<Contain> listContains = (ArrayList<Contain>) ReadWriteFile.read(Constant.FILE_PATH_CONTAIN);	
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<Book> listBook = new  ArrayList<Book>();
	
	public BookCaseServices(int bookCaseID, ArrayList<Book> listBook) {
		super();
		this.bookCaseID = bookCaseID;
		this.listBook = listBook;
	}

	public void viewBookCase() {
		for (Contain contain : listContains) {
			if (contain.getBookCaseID() == bookCaseID) {
				for (Book book : listBook) {
					if (book.getBookID() == contain.getBookID()) {
						books.add(book);
					}
				}
			}
		}
		System.out.println("Your BookCase has " + books.size() + " books:");
		if (books.size() > 0) {
			Validator.displayAllBook(books);
		} else {
			System.out.println("Your BookCase is empty!");
		}
		books.clear();
	}

	public void editBookCase() {
		int choice;
		do {
			System.out.println("1. Add a new book");
			System.out.println("2. Remove a book");
			System.out.println("3. Clear BookCase");
			System.out.println("Please enter the number: ");
			choice = Validator.checkInputIntLimit(1, 3);
			switch (choice) {
			case 1:
				System.out.print("Please enter book's id: ");
				int id = Validator.checkInputInt();
				addBookCase(id);
				break;
			case 2:
				System.out.print("Please enter book's id: ");
				int id2 = Validator.checkInputInt();
				deleteBookCase(id2);
				break;
			case 3:
				clearBookCase();
			}
			System.out.println("Do you want to continue? (Yy/Nn)");
		} while (Validator.checkInputYN());
		ReadWriteFile.write(listContains, Constant.FILE_PATH_CONTAIN);
	}

	public void addBookCase(int id) {
		boolean check = false;
		for (Book book : listBook) {
			if (book.getBookID() == id) {
				listContains.add(new Contain(bookCaseID, id, java.time.LocalDate.now().toString()));
				check = true;
			}
		}
		if (check) {
			System.out.println("Add successfully!");
		} else {
			System.out.println("Book not found");
		}
	}

	public void deleteBookCase(int id) {
		boolean check = false;
		Contain containR = new Contain();
		for (Contain contain : listContains) {
			if (contain.getBookCaseID() == bookCaseID && contain.getBookID() == id) {
				containR = contain;
				check = true;
			}
		}
		if (check) {
			listContains.remove(containR);
			System.out.println("Delete successfully!");
		} else {
			System.out.println("Delete Fail!!");
		}
	}

	public void clearBookCase() {
		ArrayList<Contain> contains = new ArrayList<Contain>();
		for (Contain contain : listContains) {
			if (contain.getBookCaseID() == bookCaseID) {
				contains.add(contain);
			}
		}
		if (contains.size() > 0) {
			for (Contain contain : contains) {
				listContains.remove(contain);
			}
			System.out.println("Clear successfully!\r\n"
					+ "Your BookCase is empty!");
		} else {
			System.out.println("Your BookCase is empty!");
		}
	}

}
