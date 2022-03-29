package Management;

import Entity.User;
import Service.LoginService;
import Service.Admin.BookService;
import Service.user.BookUserService;
import Util.Constant;

public class ReadBookManagement {

	public static void main(String[] args) {
		do {
			User user = LoginService.login();
			if (user.getRoleID() == Constant.IDROLE_USER) {
				System.out.println("Hello User, Please select a function bellow by entering the corresponding number!");
				BookUserService bus = new BookUserService();
				bus.action(user.getBookCaseID());
			} else if (user.getRoleID() == Constant.IDROLE_ADMIN) {
				System.out.println("Hello Admin, Please select a function bellow by entering the corresponding number!");
				BookService bas = new BookService();
				bas.action();
			}
		} while (true);
	}
}
