package zifuliu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo3 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("E:\\情书.txt");
			String s = "";//存放在string临时变量
			int x=fr.read();
			while(x!=-1) {
				
				char y= (char)x;//将读取的数据转为字符
				String a = y+"";//将字符转为字符串
				if(y>='a' && y<='z') {
					a=a.toUpperCase();//转大写
				}else if(y>='A' && y<='Z') {
					a=a.toLowerCase();//转小写
				}
				s=s+a;
				x=fr.read();
			}
			fr.close();
			//通过缓冲流写回源文件
			FileWriter fw = new FileWriter("E:\\\\情书.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write(s);
			pw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
