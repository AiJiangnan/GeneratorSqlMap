package com.ajn.mybatis.generator.api.generate.impl;

import java.io.File;
import java.util.List;

import com.ajn.mybatis.generator.api.generate.GenerateFile;
import com.ajn.mybatis.generator.config.JdbcConfiguration;
import com.ajn.mybatis.generator.config.XmlConfiguration;
import com.ajn.mybatis.generator.config.impl.JdbcConfigurationImpl;
import com.ajn.mybatis.generator.config.impl.XmlConfigurationImpl;
import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.template.InterfaceTemplate;
import com.ajn.mybatis.generator.template.impl.InterfaceTemplateImpl;
import com.ajn.mybatis.generator.utils.FileUtil;
import com.ajn.mybatis.generator.utils.NameUtil;

public class GenerateInterface implements GenerateFile {

	private XmlConfiguration xmlConfig = new XmlConfigurationImpl();
	private JdbcConfiguration jdbcConfig = new JdbcConfigurationImpl();
	private InterfaceTemplate interfaceTemplate = new InterfaceTemplateImpl();

	@Override
	public void generateFile() {
		List<Tables> tables = xmlConfig.getTables();

		String interfaceDirPath = NameUtil
				.packageToDir(xmlConfig.getOutputPath().getInterfacePath().get("targetPackage"));
		String interfaceProPath = xmlConfig.getOutputPath().getInterfacePath().get("targetProject");

		for (Tables table : tables)
			genOneFile(interfaceProPath + interfaceDirPath, table);
	}

	private void genOneFile(String dirName, Tables table) {
		// List<TableProp> list = jdbcConfig.getTables(table.getTableName());
		String fileName = String.format(Constants.JAVA_MAPPER_NAME, NameUtil.bigHumpName(table.getTableName()));
		String interfacePakPath = xmlConfig.getOutputPath().getInterfacePath().get("targetPackage");
		String modelPakPath = xmlConfig.getOutputPath().getModelPath().get("targetPackage");
		String result = interfaceTemplate.genInterface(interfacePakPath, modelPakPath, table);
		File file = FileUtil.newFile(dirName, fileName);
		FileUtil.writeFile(file, result);
	}
}
