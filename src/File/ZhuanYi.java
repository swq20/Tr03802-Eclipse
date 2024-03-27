package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ZhuanYi {
			
			public static void main(String[] args) {
				File e=new File("E:\\one.txt");
				File d=new File("E:\\two.txt");
				if (e.exists()) {
					try {
						
						FileOutputStream fils=new FileOutputStream(d);
						
						FileInputStream flis=new FileInputStream(e);
						flis.close();
						fils.close();
						e.delete();
						System.out.println("删除成功");
						
					} catch (FileNotFoundException x) {
						// TODO Auto-generated catch block
						x.printStackTrace();
					} catch (IOException x) {
						// TODO Auto-generated catch block
						x.printStackTrace();
					}
					
				}else {
					try {
						e.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("创建成功");
				}
				
			}
}
