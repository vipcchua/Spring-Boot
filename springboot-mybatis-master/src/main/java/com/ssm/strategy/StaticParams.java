package com.ssm.strategy;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/


import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.CchuaProperties;

public class StaticParams {
	
	public static class USERROLE {
		public static final String ADMIN ="ADMIN";
		public static final String USER = "USER";
	}
	
	public static class PATHREGX {
	
		private final static String getPathRex(String path){
	
			return  "/"+path+"/**"  ;
			
			
			
		}
		
		public static final String VIEW = getPathRex(PATH.VIEW);
		public static final String ADMIN = getPathRex(PATH.ADMIN);
		public static final String API = getPathRex(PATH.API);
		public static final String RESOURCE = getPathRex(PATH.RESOURCE);
		public static final String STATIC = getPathRex(PATH.STATIC);
		public static final String JS = getPathRex(PATH.JS);
		public static final String CSS = getPathRex(PATH.CSS);
		public static final String IMG = getPathRex(PATH.IMG);
		public static final String Fonts = getPathRex(PATH.Fonts);
		public static final String Image = getPathRex(PATH.Image);
		public static final String index = getPathRex(PATH.index);
		public static final String data = getPathRex(PATH.data);
		
	}
	
	public static class PATH {
		
		public static String data;
		public static String index;
		public static final String Image = "image";
		public static final String Fonts = "fonts";
		public static final String VIEW = "view";
		public static final String ADMIN = "admin";
		public static final String API = "api";
		public static final String RESOURCE = "resource";
		public static final String STATIC = "static";
		public static final String JS = "js";
		public static final String CSS = "css";
		public static final String IMG = "img";
	}

}
