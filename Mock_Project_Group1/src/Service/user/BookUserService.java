package Service.user;

import java.util.ArrayList;

import Entity.Book;
import Entity.Contain;
import Util.Constant;
import Util.ReadWriteFile;
import Util.Validator;

public class BookUserService implements InterfaceUser {

	ArrayList<Book> listBook = (ArrayList<Book>) ReadWriteFile.read(Constant.FILE_PATH_BOOK);
	ArrayList<Contain> listContains = (ArrayList<Contain>) ReadWriteFile.read(Constant.FILE_PATH_CONTAIN);
	ArrayList<Book> books = new ArrayList<Book>();

	@Override
	public void viewListBooks() {
		if (listBook.size() > 0) {
			Validator.displayAllBook(listBook);
		} else {
			System.out.println("There is not any book in application");
		}
	}

	@Override
	public void viewBookDetail() {
		int idBook = 0; // id of book which user enter from keyboard
		System.out.printf("Please enter id of book: ");
		idBook = Validator.checkInputInt();
		System.out.println();
		Book bs = null;
		for (Book b : listBook) {
			if (b.getBookID() == idBook) {
				bs = b;
			}
		}
		System.out.println("\t\t\t------ Book ------");
		if (bs != null) {
			System.out.println(bs.getBookTitle() + ": ");
			System.out.println(bs.getContent());
		} else {
			System.out.println("This book is not exits!");
		}
	}

	@Override
	public void searchBook() {
		System.out.println("Enter the author you want to search for");
		System.out.println("Please select search type: \r\n" + "1.By name\r\n" + "2.By author\r\n" + "3.By category");
		int choose;
		choose = Validator.checkInputIntLimit(1, 3);
		switch (choose) {
		case 1:
			System.out.println("Search for books by name: ");
			System.out.print("Enter book's name: ");
			String name = Validator.checkInputString();
			for (Book book : listBook) {
				if (book.getBookTitle().equals(name)) {
					books.add(book);
				}
			}
			break;
		case 2:
			System.out.println("Search for books by author: ");
			System.out.print("Enter author's name: : ");
			String authorname = Validator.checkInputString();
			for (Book book : listBook) {
				if (book.getAuthor().equals(authorname)) {
					books.add(book);
				}
			}
			break;
		case 3:
			System.out.println("Search for books by category: ");
			System.out.print("Enter category's name: : ");
			String categoryname = Validator.checkInputString();
			for (Book book : listBook) {
				if (book.getCategory().equals(categoryname)) {
					books.add(book);
				}
			}
			break;
		}
		if (books.size() > 0) {
			Validator.displayAllBook(books);
			books.clear();
		} else {
			System.out.println("Sorry, the book you are looking for is not available !!!");
		}
	}

	public int menu() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("1. View List Books");
		System.out.println("2. Search Books");
		System.out.println("3. Read Book");
		System.out.println("4. View Your BookCase");
		System.out.println("5. Edit Your BookCase");
		System.out.println("6. Logout");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.print("Your Selected Option Is:");
		return Validator.checkInputIntLimit(1, 6);
	}

	public void action(int bookCaseID) {
		BookCaseServices bookCaseServices;
		do {
			int choice = menu();
			switch (choice) {
			case 1:
				System.out.println("---------------------------------------------------------------------------------");
				viewListBooks();
				break;
			case 2:
				System.out.println("---------------------------------------------------------------------------------");
				searchBook();
				break;
			case 3:
				System.out.println("---------------------------------------------------------------------------------");
				viewBookDetail();
				break;
			case 4:
				System.out.println("---------------------------------------------------------------------------------");
				bookCaseServices = new BookCaseServices(bookCaseID, listBook);
				bookCaseServices.viewBookCase();
				break;
			case 5:
				System.out.println("---------------------------------------------------------------------------------");
				bookCaseServices = new BookCaseServices(bookCaseID, listBook);
				bookCaseServices.editBookCase();
				break;
			case 6:
				return;
			}
		} while (true);
	}
}
