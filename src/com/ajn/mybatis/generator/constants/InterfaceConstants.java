package com.ajn.mybatis.generator.constants;

/**
 * 生成接口文件中的字符串模板
 * 
 * @author 艾江南
 *
 */
public interface InterfaceConstants {

	final static String INTERFACE_BEGIN = "public interface %sMapper{";
	final static String INTERFACE_END = "}";
	final static String SELECT_ALL_METHOD = "\tList<%s> selAll();\r\n";

}
