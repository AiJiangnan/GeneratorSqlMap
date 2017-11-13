package com.ajn.mybatis.generator.template;

import java.util.List;

import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;

/**
 * 生成Mapper的XML文件的模板
 * 
 * @author 艾江南
 *
 */
public abstract class MapperTemplate {

	protected abstract String genDoctype();

	protected abstract String genMapperBegin(String interfaceFullName, Tables table);

	protected abstract String genMapperEnd();

	protected abstract String genSqlList(List<TableProp> tableProp, Tables table);

	protected abstract String genResultMap();

	public final String genMapper(String interfacePak, Tables table, List<TableProp> tableProp) {
		String result = "";
		result += genDoctype();
		result += genMapperBegin(interfacePak, table);
		result += Constants.NEXT_LINE;
		result += genSqlList(tableProp,table);
		result += Constants.NEXT_LINE;
		result += genResultMap();
		result += Constants.NEXT_LINE;
		result += genMapperEnd();
		return result;
	}

}
