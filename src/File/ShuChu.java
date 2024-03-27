package File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ShuChu {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			//1、第一步：创建输出对象
			FileOutputStream fos = new FileOutputStream("E:\\io.txt",true);
			//2、第二步：写入
			String x = in.next();
			fos.write(x.getBytes());
			//3、第三步：关闭
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件路径错误！或文件找不到！");
		} catch (NumberFormatException e) {
			System.out.println("转换有误！");
		} catch (IOException e) {
			System.out.println("写入有误！");
		}
	}
}
