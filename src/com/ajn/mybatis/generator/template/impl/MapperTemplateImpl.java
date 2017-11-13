package com.ajn.mybatis.generator.template.impl;

import java.util.List;

import com.ajn.mybatis.generator.constants.MapperConstants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.template.MapperTemplate;

public class MapperTemplateImpl extends MapperTemplate {

	@Override
	protected String genDoctype() {
		return MapperConstants.MAPPER_XML_DOCTYPE;
	}

	@Override
	protected String genMapperBegin(String interfaceFullName, String className) {
		return String.format(MapperConstants.MAPPER_XML_BEGIN, interfaceFullName + "." + className);
	}

	@Override
	protected String genMapperEnd() {
		return MapperConstants.MAPPER_XML_END;
	}

	@Override
	protected String genSqlList(List<TableProp> tableProp) {
		String list = "";
		for (int i = 0, n = tableProp.size(); i < n; i++) {
			list += tableProp.get(i).getColumnName();
			if (i < n - 1)
				list += ",";
		}
		return String.format(MapperConstants.MAPPER_XML_SQL_LIST, list);
	}

	@Override
	protected String genResultMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
