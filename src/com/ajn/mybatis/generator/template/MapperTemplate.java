package com.ajn.mybatis.generator.template;

/**
 * 生成Mapper的XML文件的模板
 * 
 * @author 艾江南
 *
 */
public abstract class MapperTemplate {

	protected abstract String genDoctype();

	protected abstract String genMapperBegin();

	protected abstract String genMapperEnd();

	protected abstract String genSqlList();

	protected abstract String genResultMap();

	public final String genMapper() {
		String result = "";
		result += genDoctype();
		result += genMapperBegin();
		result += genSqlList();
		result += genResultMap();
		result += genMapperEnd();
		return result;
	}

}
