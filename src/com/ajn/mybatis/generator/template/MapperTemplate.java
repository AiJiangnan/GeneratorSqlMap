package com.ajn.mybatis.generator.template;

import java.util.List;

import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.utils.NameUtil;

/**
 * 生成Mapper的XML文件的模板
 * 
 * @author 艾江南
 *
 */
public abstract class MapperTemplate {

	protected abstract String genDoctype();

	protected abstract String genMapperBegin(String interfaceFullName, String className);

	protected abstract String genMapperEnd();

	protected abstract String genSqlList(List<TableProp> tableProp);
	
	protected abstract String genSqlMethod(String tableName, List<TableProp> tableProp);

	protected abstract String genResultMap();

	public final String genMapper(String interfacePak, Tables table, List<TableProp> tableProp) {
		String className = table.getClassName();
		String tableName = table.getTableName();
		className = className == null || "".equals(className) ? NameUtil.bigHumpName(tableName) : className;
		String result = "";
		result += genDoctype();
		result += genMapperBegin(interfacePak, className);
		result += Constants.NEXT_LINE;
		result += genSqlList(tableProp);
		result += Constants.NEXT_LINE;
		// result += genResultMap();
		result += genSqlMethod(tableName,tableProp);
		result += Constants.NEXT_LINE;
		result += genMapperEnd();
		return result;
	}

}
