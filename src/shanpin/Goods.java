package shanpin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

public class Goods {
	
	File file  = new File("E:\\测试文件\\商品信息.txt");
	Scanner input = new Scanner(System.in);
	YanZheng yz = new YanZheng();
	//录入商品信息
	public void insert() {
		String shuju = "";
		
		System.out.println("请输入商品名称：");
		String name = input.next();
		shuju=shuju+name+"、";
		
		System.out.println("请输入商品生产日期：");
		String Date = input.next();
		try {
			yz.shenchangDate(Date);
			shuju=shuju+Date+"、";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("请输入商品保质期：");
		String baozhiqi = input.next();
		try {
			yz.baozhiqiYanZheng(baozhiqi);
			shuju=shuju+baozhiqi+"、";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("请输入商品价格：");
		String jiage = input.next();
		try {
			yz.jiageYanZheng(jiage);
			shuju=shuju+jiage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileWriter fw;
		try {
			fw = new FileWriter(file,true);
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
	
	//查询所有商品
	public void selectAll() {
		try {
			FileReader 	fr = new FileReader(file);
			BufferedReader bd = new BufferedReader(fr);
			String shuju =bd.readLine();
			while(shuju!=null) {
				System.out.println(shuju);
				shuju =bd.readLine();
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
	
	//根据商品名称查询
	public void WhereNameSelect() {
		System.out.println("请输入你要查询的商品名称：");
		String name = input.next();
		try {
			FileReader	fr = new FileReader(file);
			BufferedReader bd = new BufferedReader(fr);
			String shuju = bd.readLine();
			while(shuju!=null) {
				if(name.startsWith(shuju.substring(0,shuju.indexOf("、")))){
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
	
	
	//修改商品
	public void Update() {
		
	}
	
	
	//菜单
	public void menu() {
		System.out.println("1、录入商品信息   2、查询全部商品   3、根据商品名称查询    4、修改");
		int a = input.nextInt();
		switch (a) {
		case 1:
			insert();
			break;
		case 2:
			selectAll();
			break;
		case 3:
			WhereNameSelect();
			break;
		case 4:
			Update();
			break;
		case 5:
			break;
		default:
			break;
		}
		
	}
}
