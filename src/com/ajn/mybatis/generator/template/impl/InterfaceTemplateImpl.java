package com.ajn.mybatis.generator.template.impl;

import com.ajn.mybatis.generator.constants.InterfaceConstants;
import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.template.InterfaceTemplate;
import com.ajn.mybatis.generator.utils.NameUtil;

public class InterfaceTemplateImpl extends InterfaceTemplate {

	@Override
	protected String genPackage(String packageName) {
		return String.format(Constants.PACKAGE, packageName);
	}

	@Override
	protected String genInterfaceBegin(Tables table) {
		String className = table.getClassName();
		String tableName = NameUtil.bigHumpName(table.getTableName());
		return String.format(InterfaceConstants.INTERFACE_BEGIN,
				className == null || "".equals(className) ? tableName : className);
	}

	@Override
	protected String genInterfaceEnd() {
		return InterfaceConstants.INTERFACE_END;
	}

	@Override
	protected String genMethod(Tables table) {
		String className = table.getClassName();
		String tableName = NameUtil.bigHumpName(table.getTableName());
		return String.format(InterfaceConstants.SELECT_ALL_METHOD,
				className == null || "".equals(className) ? tableName : className);
	}

	@Override
	protected String genImport(String modelPakName, Tables table) {
		String result = "";
		String className = table.getClassName();
		String tableName = NameUtil.bigHumpName(table.getTableName());
		result += Constants.IMPORT_LIST;
		result += String.format(Constants.IMPORT_MODEL, modelPakName,
				className == null || "".equals(className) ? tableName : className);
		return result;
	}

}
