package Service.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Book;
import Util.Constant;
import Util.ReadWriteFile;
import Util.Validator;

public class BookService implements InterfaceAdmin {

	List<Book> listBook = getlistBook();

	@SuppressWarnings("unchecked")
	public List<Book> getlistBook() {
		ArrayList<Book> getListBooks = (ArrayList<Book>) ReadWriteFile.read(Constant.FILE_PATH_BOOK);
		return getListBooks;
	}

	@Override
	public void createBook() {
		String bookTitle, author, brief, publisher, content, category;
		System.out.println("Enter the book bookTitle: ");
		bookTitle = Validator.checkInputString();

		System.out.println("Enter the author's name: ");
		author = Validator.checkInputString();

		System.out.println("Enter a brief description of the book: ");
		brief = Validator.checkInputString();

		System.out.println("Enter the book publisher: ");
		publisher = Validator.checkInputString();

		System.out.println("Enter the book content: ");
		content = Validator.checkInputString();

		System.out.println("Enter the book category: ");
		category = Validator.checkInputString();

		int id = 1;
		if (listBook.size() > 0) {
			id = listBook.get(listBook.size() - 1).getBookID() + 1;
		}
		Book book = new Book(id, bookTitle, author, brief, publisher, content, category);
		boolean add = listBook.add(book);
		if (add) {
			System.out.println("Book successfully created! ");
		} else {
			System.out.println("Book fail created! ");
		}
	}

	@Override
	@SuppressWarnings("resource")
	public void updateContentBook() {
		int dem = 0;
		
			System.out.println("Please enter book's id:");
			int id = Validator.checkInputInt();
			if (listBook.size() > 0 || listBook != null) {
				for (Book b : listBook) {
					if (id == b.getBookID()) {
						String cont = b.getContent();
						System.out.println("Enter the new content: ");
						b.setContent(Validator.checkInputString());
						dem++;
						if (cont != b.getContent()) {
							System.out.println("Book successfully updated!");
						}
					}
				}
				if (dem < 1) {
					System.out.println("This book does not exist!");
					System.out.println(
							"---------------------------------------------------------------------------------");
				}
			}
		
	}

	@Override
	@SuppressWarnings("unused")
	public void deleteBook() {
		System.out.println("Please enter book's id:");
		int id = Validator.checkInputInt();
		if (listBook.size() > 0 || listBook != null) {
			List<Book> toRemove = new ArrayList<>();
			for (Book b : listBook) {
				if (id == b.getBookID()) {
					toRemove.add(b);
				}
			}
			boolean isRemoved = listBook.removeAll(toRemove);
			if (isRemoved) {
				System.out.println("Delete completed! ");
			} else {
				System.out.println("Delete Fail!! ");
			}
		}
	}

	public void display() throws IOException {
		System.out.println("Display All Book: ");
		if (listBook.size() > 0) {
			Validator.displayAllBook(listBook);
		} else {
			System.out.println("There is not any book in application");
		}
	}

	public int menu() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("1. Display all:");
		System.out.println("2. Creat Book:");
		System.out.println("3. Update Book:");
		System.out.println("4. Delete Book:");
		System.out.println("5. Register");
		System.out.println("6. Logout");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.print("Your Selected Option Is:");
		return Validator.checkInputIntLimit(1, 6);
	}

	public void action() {
		do {
			int choice = menu();
			switch (choice) {
			case 1:
				try {
					System.out.println(
							"---------------------------------------------------------------------------------");
					display();
					break;
				} catch (IOException e) {
					e.printStackTrace();
				}
			case 2:
				System.out.println("---------------------------------------------------------------------------------");
				createBook();
				break;
			case 3:
				System.out.println("---------------------------------------------------------------------------------");
				updateContentBook();
				break;
			case 4:
				System.out.println("---------------------------------------------------------------------------------");
				deleteBook();
				break;
			case 5:
				UserServices.register();
				break;
			case 6:
				ReadWriteFile.write(listBook, Constant.FILE_PATH_BOOK);
				return;
			}
		} while (true);
	}
}
