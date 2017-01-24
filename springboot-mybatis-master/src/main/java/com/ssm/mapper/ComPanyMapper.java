package com.ssm.mapper;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/


import com.ssm.model.CompanyInfo;
import com.ssm.model.CompanyInfoSql;
import com.ssm.model.TableInfo;
import com.ssm.model.TableInfoSql;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.sound.midi.MidiDevice.Info;

import org.apache.ibatis.annotations.*;

@Mapper

public interface ComPanyMapper {


	@Select("SELECT * FROM  company_info")
	List<CompanyInfo> selectcomoanty();
	

	@UpdateProvider(type = CompanyInfoSql.class, method = "UpdateCompanyInfo")
	public void UpCompanyInfo(CompanyInfo companyInfo);
		
	

	
}
