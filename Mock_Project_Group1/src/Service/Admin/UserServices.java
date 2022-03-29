package Service.Admin;

import java.util.ArrayList;

import Entity.*;
import Util.Constant;
import Util.ReadWriteFile;
import Util.Validator;

public class UserServices {
	static ArrayList<User> users = (ArrayList<User>) ReadWriteFile.read(Constant.FILE_PATH_PERSON);
	static ArrayList<Role> roles = (ArrayList<Role>) ReadWriteFile.read(Constant.FILE_PATH_ROLE);
	static ArrayList<BookCase> bookCases = (ArrayList<BookCase>) ReadWriteFile.read(Constant.FILE_PATH_BOOKCASE);

	public static void register() {
		boolean check = false;
		String userName;
		System.out.println("\t\t\t----- Register -----");
		do {
			System.out.println("Username: ");
			userName = Validator.checkInputString();
			for (User user : users) {
				if (user.getUserName().equalsIgnoreCase(userName)) {
					System.out.println("Username is already taken");
					check = true;
				}
			}
		} while (check);
		System.out.println("Password: ");
		String password = Validator.checkInputString();
		int i = 0;
		for (Role role : roles) {
			System.out.println(++i + ": " + role.getAuthority());
		}
		System.out.println("Choice type of Accout:");
		int role = Validator.checkInputIntLimit(1, roles.size());
		int bookCaseId = users.get(users.size() - 1).getBookCaseID() + 1;
		int id = users.get(users.size() - 1).getId() + 1;
		users.add(new User(id, userName, password, bookCaseId, role));
		ReadWriteFile.write(users, Constant.FILE_PATH_PERSON);
		bookCases.add(new BookCase(bookCaseId, "BookCase_" + userName));
		ReadWriteFile.write(bookCases, Constant.FILE_PATH_BOOKCASE);
	}
}
