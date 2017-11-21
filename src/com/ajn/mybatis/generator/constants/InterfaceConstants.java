package com.ajn.mybatis.generator.constants;

/**
 * 生成接口文件中的字符串模板
 * 
 * @author 艾江南
 *
 */
public interface InterfaceConstants {

	final static String INTERFACE_BEGIN = "public interface %sMapper {";
	final static String INTERFACE_END = "}";

	/**
	 * 接口中的方法
	 */
	final static String SELECT_ENTITY_LIST_METHOD = "\tList<%s> sel%sList();";
	final static String INSERT_ENTITY_METHOD = "\tint ins%s(%s);";

}
