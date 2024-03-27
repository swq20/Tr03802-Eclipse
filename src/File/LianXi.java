package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class LianXi {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		File file = new File("E:\\trkj.txt");
		if(file.exists()) {
			System.out.println("文件路径："+file.getPath());
			System.out.println("文件名字："+file.getName());
			Date d = new Date(file.lastModified());
			System.out.println("最后修改时间："+d.toLocaleString());
			System.out.println("文件大小："+file.length());
			
			try {
				FileInputStream fps = new FileInputStream(file);
				int a= fps.read();
				while(a!=-1) {
				 System.out.print((char)a); 
				 a=fps.read();
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("文件不存在");
			try {
				file.createNewFile();
				System.out.println("输入内容：");
				FileOutputStream fos = new FileOutputStream(file);
				String x= in.next();
				fos.write(x.getBytes());
				fos.write('\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
