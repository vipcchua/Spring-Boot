  import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;
import java.util.UUID;  
public class DateTest {  
  
    public static void main(String[] args) throws ParseException {  
  
    	
System.out.println(uuid());
    } 
    
    
    
	private static String uuid() throws ParseException {
        Date d = new Date();  
        /*System.out.println(d);  */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateNowStr = sdf.format(d);  
        /*System.out.println("格式化后的日期：" + dateNowStr);  */
          
        String str = "2012-1-13 17:26:33";  //要跟上面sdf定义的格式一样  
        Date today = sdf.parse(str);  
        /*System.out.println("字符串转成日期：" + today);*/
		return dateNowStr;  
	}
    
    
}  