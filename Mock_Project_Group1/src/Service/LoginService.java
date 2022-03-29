package Service;

import java.util.List;
import java.util.Scanner;

import Entity.User;
import Util.Constant;
import Util.ReadWriteFile;
import Util.Validator;

public class LoginService {
	public static User login() {
        int timeTried = 0;
        boolean finish = false;
        User loginSucess = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("---Welcome to Read Book Application! Please enter your username and password---");
        System.out.println("-------------------------------------------------------------------------------");

        //vong lap dang nhap
        while (!finish) {
            timeTried++;
            if (timeTried < 5) {
                System.out.println("Username: ");
                String username = sc.next();
                System.out.println("Password: ");
                String pass = sc.next();
                loginSucess = verifyLogin(username, pass);
                if (loginSucess == null) {
                    System.out.println("UserName or Password is wrong!\n" +
                            "Please enter again:");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Do you want to continue? (Yy/Nn)");
                    if (!Validator.checkInputYN()) {
                    	System.exit(0);
					}
                } else {
                    finish = true;
                }
            } else if (timeTried == 5) {
                System.out.println("Username: ");
                String username = sc.next();
                System.out.println("Password: ");
                String pass = sc.next();
                loginSucess = verifyLogin(username, pass);
                if (loginSucess == null) {
                    System.out.println("Read Book Application is closed because you have entered the wrong input too many times. Please run again.");
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                } else {
                    finish = true;
                }
            } else {
                System.exit(0);
            }
        }
     
        return loginSucess;
	}
	
	public static User verifyLogin(String username, String password) {
        List<User> lisu  = (List<User>) ReadWriteFile.read(Constant.FILE_PATH_PERSON);
        for (User user : lisu) {
			if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
        return null;
    }
}
