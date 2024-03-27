package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class zy3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		File file = new File("E:\\zktr");
		if(file.exists()) {
			try {
				FileOutputStream fos = new FileOutputStream("E:\\zktr\\a.txt",true);
				System.out.println("输入内容");
				String x= in.next();
				fos.write('\n');
				fos.write(x.getBytes());
				fos.close();
				System.out.println("输入成功！");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			file.mkdir();
		}
	}
}
