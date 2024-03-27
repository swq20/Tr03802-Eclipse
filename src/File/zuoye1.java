package File;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

public class zuoye1 {
	public static void main(String[] args) {
		File file = new File("E:\\io测试");
		if(file.exists() && file.isDirectory()) {
			bianli(file);
		}else {
			System.out.println("文件路径无效或无文件夹！");
		}
	}
	
	public static void bianli(File f) {
		 File[] files = f.listFiles();
		 if(files!=null) {
			 for(File x:files) {
				 Date d = new Date(x.lastModified());
				 if(x.isFile()) {
					 
					 System.out.println("文件: " + x.getName());
	                 System.out.println("大小: " + x.length());
	                 System.out.println("最后修改时间: " + d.toLocaleString());
				 }else if(x.isDirectory()){
					 System.out.println("文件夹: " + x.getName());
	                 System.out.println("大小: " + x.length());
	                 System.out.println("最后修改时间: " + d.toLocaleString());
				}
			 }
		 }
	}
}
