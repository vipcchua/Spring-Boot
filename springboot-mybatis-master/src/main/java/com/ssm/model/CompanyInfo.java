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


public class CompanyInfo {
    /**
    * 序号
    */
    private String id;

    private String companyName;
    
    private String companyLogo;

    private int tableTotal;
    
    





	public int getTableTotal() {
		return tableTotal;
	}

	public void setTableTotal(int tableTotal) {
		this.tableTotal = tableTotal;
	}

    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
    
    
    
    
    
}