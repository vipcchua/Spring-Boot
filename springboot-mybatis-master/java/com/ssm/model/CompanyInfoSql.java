package com.ssm.model;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/


import org.apache.ibatis.jdbc.SQL;


import com.ssm.model.CompanyInfo;
public class CompanyInfoSql {
	
	
	public String UpdateCompanyInfo(final CompanyInfo companyInfo) {
		return new SQL() {
			{
				UPDATE("company_info");
				
				if (companyInfo.getCompanyName() != null) {
					SET("company_info.company_name = #{companyName}");
				}
			
				if (companyInfo.getCompanyLogo() != null) {
					SET("company_info.company_logo = #{companyLogo}");
				}

				
				
				
				WHERE("id = #{id}");
			}
		}.toString();
	}
	
	
	
	
	
}