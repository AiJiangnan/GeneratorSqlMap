package com.ajn.mybatis.generator.template.impl;

import java.util.List;

import com.ajn.mybatis.generator.constants.ModelTemplate;
import com.ajn.mybatis.generator.constants.Template;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.template.PojoTemplate;
import com.ajn.mybatis.generator.utils.NameUtil;

public class PojoTemplateImpl extends PojoTemplate {

	@Override
	protected String genPackage(String packageName) {
		return String.format(Template.PACKAGE, packageName);
	}

	@Override
	protected String genClassBegin(Tables table) {
		String className = table.getClassName();
		String tableName = NameUtil.bigHumpName(table.getTableName());
		return String.format(ModelTemplate.CLASS_BEGIN,
				className == null || "".equals(className) ? tableName : className);
	}

	@Override
	protected String genClassEnd() {
		return ModelTemplate.CLASS_END;
	}

	@Override
	protected String genVariable(List<TableProp> tableProp) {
		String result = "";
		for (TableProp table : tableProp) {
			result += String.format(ModelTemplate.VARIABLE, table.getColumnClassName(),
					NameUtil.humpName(table.getColumnName()));
		}
		return result;
	}

	@Override
	protected String genGetter(List<TableProp> tableProp) {
		String result = "";
		for (TableProp table : tableProp) {
			String humpName = NameUtil.humpName(table.getColumnName());
			String bigHumpName = NameUtil.bigHumpName(table.getColumnName());
			result += String.format(ModelTemplate.GETTER, table.getColumnClassName(), bigHumpName, humpName);
			result += Template.NEXT_LINE;
		}
		return result;
	}

	@Override
	protected String genSetter(List<TableProp> tableProp) {
		String result = "";
		for (TableProp table : tableProp) {
			String humpName = NameUtil.humpName(table.getColumnName());
			String bigHumpName = NameUtil.bigHumpName(table.getColumnName());
			result += String.format(ModelTemplate.SETTER, bigHumpName, table.getColumnClassName(), humpName, humpName,
					humpName);
			result += Template.NEXT_LINE;
		}
		return result;
	}

}
