package shanpin;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class YanZheng {
	
	public boolean shenchangDate(String date) throws ParseException {
		//验证生产日期格式是否为yyyy-MM-dd
		 String pattern = "yyyy-MM-dd";
	     SimpleDateFormat format = new SimpleDateFormat(pattern);
	     try {
	            format.parse(date);
	            return true;
	        } catch (ParseException e) {
	            throw new ParseException("时间格式不合法",0);
	        }
	}
	
	
	public boolean baozhiqiYanZheng(String bzq) throws Exception {
		try {
			Integer index =null;
			if(bzq.indexOf("天")!=-1) {
				index=bzq.indexOf("天");
			}else if(bzq.indexOf("月")!=-1) {
				index=bzq.indexOf("月");
			}else {
				throw new Exception("请按照正确格式输入数据");
			}
			Integer.parseInt(bzq.substring(0,index));
		} catch (Exception e) {
			throw new Exception("请按照正确格式输入数据");
		}
		return false;
	}
	
	
	public boolean jiageYanZheng(String jg) throws Exception {
		try {
			Double.parseDouble(jg);
		} catch (Exception e) {
			throw new Exception("请输入合法的价格");
		}
		return false;
	}
}
