package zifuliu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AnLi {
	public static void main(String[] args) {try {
		Scanner in = new Scanner(System.in);
		File file = new File("E:\\情书.txt");
		
		//输出
		if(file.exists()) {
			System.out.println("输入内容");
			String txt = in.next();
			try {
				FileWriter fw = new FileWriter(file,true);
				fw.write(txt);
				fw.write('\n');
				fw.close();
				System.out.println("追加成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
				file.createNewFile();
			}	
		
		//输入
		FileReader fr = new FileReader(file);
		char ch[] = new char[1024];
		int a= fr.read(ch);
		System.out.println("文本中的信息是："+new String(ch,0,a));//将字符转换为字符串输出
		fr.close();
 		
		
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
