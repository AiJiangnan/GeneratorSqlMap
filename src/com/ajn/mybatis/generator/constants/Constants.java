package com.ajn.mybatis.generator.constants;

/**
 * 公共的字符串模板
 * 
 * @author 艾江南
 *
 */
public interface Constants {

	final static String PACKAGE = "package %s;";
	final static String ONE_LINE = "\r\n";
	final static String NEXT_LINE = "\r\n\r\n";
	final static String JAVA_FILE_NAME = "%s.java";
	final static String JAVA_MAPPER_NAME = "%sMapper.java";

	final static String IMPORT_MODEL = "import %s.%s;\r\n";
	final static String IMPORT_LIST = "import java.util.List;\r\n";

}
