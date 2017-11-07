package com.ajn.mybatis.generator.template;

import com.ajn.mybatis.generator.constants.Template;
import com.ajn.mybatis.generator.model.Tables;

public abstract class InterfaceTemplate {

	protected abstract String genPackage(String packageName);

	protected abstract String genInterfaceBegin(Tables table);

	protected abstract String genInterfaceEnd();

	protected abstract String genMethod(Tables table);

	protected abstract String genImport(String modelPakName, Tables table);

	public final String genInterface(String packageName, String modelPakName, Tables table) {
		String result = "";
		result += genPackage(packageName);
		result += Template.NEXT_LINE;
		result += genImport(modelPakName, table);
		result += Template.ONE_LINE;
		result += genInterfaceBegin(table);
		result += Template.NEXT_LINE;
		result += genMethod(table);
		result += Template.ONE_LINE;
		result += genInterfaceEnd();
		return result;
	}

}
