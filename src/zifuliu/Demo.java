package zifuliu;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		try {
			FileWriter fr = new FileWriter("E:\\情书.txt",true);
			PrintWriter pw = new PrintWriter(fr);
			Scanner in = new Scanner(System.in);
			System.out.println("输入内容");
			pw.write(in.next()+"\n");
			pw.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
