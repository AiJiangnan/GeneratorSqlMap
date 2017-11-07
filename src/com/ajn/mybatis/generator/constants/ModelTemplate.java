package com.ajn.mybatis.generator.constants;

public interface ModelTemplate {

	final static String PACKAGE = "package %s;";
	final static String CLASS_BEGIN = "public class %s{";
	final static String CLASS_END = "}";
	final static String VARIABLE = "\tprivate %s %s;\r\n";
	final static String GETTER = "\tpublic %s get%s() {\r\n\t\treturn %s;\r\n\t}";
	final static String SETTER = "\tpublic void set%s(%s %s) {\r\n\t\tthis.%s = %s;\r\n\t}";

}
