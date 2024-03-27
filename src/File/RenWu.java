package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class RenWu {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		File file = new File("E:\\in.txt");
		if(file.exists()) {
			try {
				FileInputStream fps = new FileInputStream(file);
				byte a[] = new byte[0];
				int x = fps.read(a);
				while(x!=-1) {
					System.out.println((char)x);
					x=fps.read();
				}
				fps.close();
			} catch (FileNotFoundException e) {
				System.out.println("文件不存在");
			} catch (IOException e) {
				System.out.println("文件读取失败");
			}
		}else {
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				String txt = in.next();
				fos.write(txt.getBytes());
				fos.close();
				System.out.println("输入成功");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
