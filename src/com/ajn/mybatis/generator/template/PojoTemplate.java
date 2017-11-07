package com.ajn.mybatis.generator.template;

import java.util.List;

import com.ajn.mybatis.generator.constants.Template;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;

public abstract class PojoTemplate {

	protected abstract String genPackage(String packageName);

	protected abstract String genClassBegin(Tables table);

	protected abstract String genClassEnd();

	protected abstract String genVariable(List<TableProp> tableProp);

	protected abstract String genGetter(List<TableProp> tableProp);

	protected abstract String genSetter(List<TableProp> tableProp);

	public final String genModel(String packageName, Tables table, List<TableProp> tableProp) {
		String result = "";
		result += genPackage(packageName);
		result += Template.NEXT_LINE;
		result += genClassBegin(table);
		result += Template.NEXT_LINE;
		result += genVariable(tableProp);
		result += Template.ONE_LINE;
		result += genGetter(tableProp);
		result += genSetter(tableProp);
		result += genClassEnd();
		return result;
	}

}
