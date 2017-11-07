package com.ajn.mybatis.generator.constants;

public interface InterTemplate {

	final static String INTERFACE_BEGIN = "public interface %sMapper{";
	final static String INTERFACE_END = "}";
	final static String SELECT_ALL_METHOD = "\tList<%s> selAll();\r\n";

}
