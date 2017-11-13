package com.ajn.mybatis.generator.template.impl;

import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.constants.InterfaceConstants;
import com.ajn.mybatis.generator.template.InterfaceTemplate;

public class InterfaceTemplateImpl extends InterfaceTemplate {

	@Override
	protected String genPackage(String packageName) {
		return String.format(Constants.PACKAGE, packageName);
	}

	@Override
	protected String genInterfaceBegin(String className) {
		return String.format(InterfaceConstants.INTERFACE_BEGIN, className);
	}

	@Override
	protected String genInterfaceEnd() {
		return InterfaceConstants.INTERFACE_END;
	}

	@Override
	protected String genMethod(String className) {
		return String.format(InterfaceConstants.SELECT_ALL_METHOD, className);
	}

	@Override
	protected String genImport(String modelPakName, String className) {
		String result = "";
		result += Constants.IMPORT_LIST;
		result += String.format(Constants.IMPORT_MODEL, modelPakName, className);
		return result;
	}

}
