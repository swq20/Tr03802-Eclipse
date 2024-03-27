package zifuliu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 创建一个学生管理系统文件
 */
public class StudentSystem {
	/**
	 * 方法一：新增学生
	 */
	Scanner in = new Scanner(System.in);
	File file = new File("E:\\学生信息.txt");
	public void insert() {
		//分析
		//1、先从控制台输入学生4个信息，拼接成 “姓名-年龄-性别-电话”字符串格式
		//[录入信息前，我们需要验证手机、年龄、性别]
		//2、通过PrintWrite追加到文件中"学生系统.txt"
		String shuju = "";
		
		System.out.println("请输入学生姓名：");
		String name = in.next();
		shuju=shuju+name+"-";
		
		
		System.out.println("请输入学生年龄：");
		Integer age = in.nextInt();
		if(age>=18 && age<=30) {
			shuju=shuju+age+"-";
		}else {
			System.out.println("输入的年龄不符合要求");
		}
		
		
		System.out.println("请输入学生电话：");
		String phone = in.next();
		if(phone.length()==11) {
			shuju=shuju+phone+"-";
		}else {
			System.out.println("请输入正确的号码");
		}
		
		
		System.out.println("请输入学生性别");
		String sex = in.next();
		if(sex.equals("男") || sex.equals("女")) {
			shuju=shuju+sex;
		}else {
			System.out.println("请输入正确的性别（男/女）");
		}
		
		try {
			FileWriter fw = new FileWriter(file,true);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(shuju+'\n');
			System.out.println("新增成功");
			menu();
			pw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * 方法二：删除学生
	 */

public void delete() {
		//输入删除的学生姓名
		//通过BufferedReader输入流读取文件中的数据，
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要删除的学生姓名：");
		String name = in.next();
		
		try {
			FileReader 	r = new FileReader("f:/学生管理系统.txt");
		BufferedReader br = new BufferedReader(r);
		String x=br.readLine();  //"姓名-年龄-性别-电话"
		String s="";//保存不要删除的学生信息
		//读行比较一行
		while(x!=null) {
			if( !x.startsWith(name) ) {//如果不是要删除的学生
				//累加到
				s=s+x+"\n";
			}
			 x=br.readLine();
	   }
		//通过PrintWriter写入到原文件中（覆盖）
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(s);
		System.out.println("删除成功");
		menu();
		pw.close();
		fw.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
		} catch (IOException e) {
			System.out.println("读取失败");
		}
	}
	
	/**
	 * 方法三：查询所有学生（仅列出编号和姓名）
	 */
	public void select() {
		int xuhao = 1;
		try {
			FileReader 	fr = new FileReader(file);
			BufferedReader bd = new BufferedReader(fr);
			String shuju =bd.readLine();
			while(shuju!=null) {
				System.out.println(xuhao+"、"+shuju.substring(0,shuju.indexOf("-")));
				shuju =bd.readLine();
				xuhao++;
			}
			menu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 方法四：根据名字查询学生信息
	 */
	public void byNameSelect() {
		System.out.println("请输入你要查询的学生姓名：");
		String name = in.next();
		try {
			FileReader	fr = new FileReader(file);
			BufferedReader bd = new BufferedReader(fr);
			String shuju = bd.readLine();
			while(shuju!=null) {
				if(name.startsWith(shuju.substring(0,shuju.indexOf("-")))){
					System.out.println(shuju);
					break;
				}
				 shuju = bd.readLine();
			}
			menu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void menu() {
		System.out.println("1、新增学生   2、查询所有学生   3、删除学生    4、根据姓名查询学生   5、退出");
		int a = in.nextInt();
		switch (a) {
		case 1:
			insert();
			break;
		case 2:
			select();
			break;
		case 3:
			delete();
			break;
		case 4:
			byNameSelect();
			break;
		case 5:
			break;
		default:
			break;
		}
		
	}
}