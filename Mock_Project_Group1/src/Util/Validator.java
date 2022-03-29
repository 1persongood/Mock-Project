package Util;

import java.util.List;
import java.util.Scanner;

import Entity.Book;

public class Validator {
	private static Scanner sc = new Scanner(System.in);

	public static int checkInputIntLimit(int min, int max) {
		// loop until user input correct
		while (true) {
			try {
				int result = Integer.parseInt(sc.nextLine().trim());
				if (result < min || result > max) {
					throw new NumberFormatException();
				}
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Please input number in rage [" + min + ", " + max + "]");
				System.out.print("Enter again: ");
			}
		}
	}

	public static String checkInputString() {
		// loop until user input correct
		while (true) {
			String result = sc.nextLine().trim();
			if (result.isEmpty()) {
				System.err.println("Not empty");
				System.out.print("Enter again: ");
			} else {
				return result;
			}
		}
	}

	public static int checkInputInt() {
		// loop until user input correct
		while (true) {
			try {
				int result = Integer.parseInt(sc.nextLine().trim());
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Please input number!");
				System.out.print("Enter again: ");
			}
		}
	}

	public static boolean checkInputYN() {
		// loop until user input correct
		while (true) {
			String result = checkInputString();
			// check user input y/Y or n/N
			if (result.equalsIgnoreCase("Y")) {
				return true;
			} else if (result.equalsIgnoreCase("N")) {
				return false;
			}
			System.err.println("Please input y/Y or n/N.");
			System.out.print("Enter again: ");
		}
	}

	public static void displayAllBook(List<Book> liBooks) {
		String format = String.format("%1$5s %2$5s %3$20s %4$20s %5$15s  %6$20s", "STT", "id", "title", "author",
				"category", "publisher");
		System.out.println(format);
		int i = 1;
		for (Book book : liBooks) {
			String formatV = String.format("%1$5s " + book.toString(), i++);
			System.out.println(formatV);
		}
	}
}
