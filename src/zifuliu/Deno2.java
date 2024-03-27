package zifuliu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Deno2 {
	//读取"情书.txt"中的内容
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("E:\\情书.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			while(s!=null) {
				System.out.println(s);
				s=br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
