package com.ajn.mybatis.generator.constants;

/**
 * 生成Mapper文件中的字符串模板
 * 
 * @author 艾江南
 *
 */
public interface MapperConstants {

	final static String MAPPER_XML_DOCTYPE = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n";
	final static String MAPPER_XML_BEGIN = "<mapper namespace=\"%s\">";
	final static String MAPPER_XML_END = "</mapper>";
	final static String MAPPER_XML_SQL_LIST = "\t<sql id=\"%s_list\">\r\n\t\t%s\r\n\t</sql>";

}
