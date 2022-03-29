package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ReadWriteFile {

	// thêm
	public static <T> void write(List<T> danhSach, String diaChi) {
		File file = new File(diaChi);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		// Khai báo FileOutputStream và FileOutputStream trỏ chúng tới null
		FileOutputStream fileOutStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			// Khởi tạo đối tượng.
			fileOutStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutStream);
			objectOutputStream.writeObject(danhSach);// Thực hiện ghi đối tượng vào file.
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// Đóng file
				fileOutStream.close();
				objectOutputStream.close();

			} catch (IOException e) {
				System.err.println(e);
			}

		}
	}

	// đọc file
	public static Object read(String diaChi) {
		// Khai báo đối tượng FileInputStream và ObjectInputStream trỏ tới null
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		Object read = null;
		try {
			// Khởi tạo đối tượng với địa chỉ truyền vào
			fileInputStream = new FileInputStream(new java.io.File(diaChi));
			objectInputStream = new ObjectInputStream(fileInputStream);
			read = objectInputStream.readObject();
			return read;
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (read == null)
				System.out.println("File read failed! ");
			try {
				fileInputStream.close();
				objectInputStream.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}

		return null;
	}

}
