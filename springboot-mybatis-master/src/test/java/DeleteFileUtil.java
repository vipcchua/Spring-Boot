import java.io.File;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import groovy.transform.ToString;

public class DeleteFileUtil {  


  
 /** 
  * 删除单个文件 
  *  
  * @param fileName 
  *            要删除的文件的文件名 
  * @return 单个文件删除成功返回true，否则返回false 
  */  
 public static boolean deleteFile(String fileName) {  
  File file = new File(fileName);  
  // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除  
  if (file.exists() && file.isFile()) {  
   if (file.delete()) {  
    System.out.println("删除单个文件" + fileName + "成功！");  
    return true;  
   } else {  
    System.out.println("删除单个文件" + fileName + "失败！");  
    return false;  
   }  
  } else {  
   System.out.println("删除单个文件失败：" + fileName + "不存在！");  
   return false;  
  }  
 }  
  
 
 
 
 
 
  
 public static void main(String[] args) {  
//  // 删除单个文件  
  String file = "D:/ssmimg/data/img/03f12c59-e5f3-4704-b035-87da8fff559f.jpg";  
  DeleteFileUtil.deleteFile(file);  

  
  String a ="['22b55c72-9969-48b5-836f-3c1294402d34.png','5fe30ce0-bad3-4e23-ad30-360d2eb84396.jpg']";
  
  
	JSONArray jsonArr = JSON.parseArray(a)  ;
    System.out.println("json2Array()方法：jsonArr=="+jsonArr.get(1).toString());  
    
    System.out.println("json2Array()方法：jsonArr=="+jsonArr.get(0).toString());  
  
  
  
  
  
 }  
  
}  