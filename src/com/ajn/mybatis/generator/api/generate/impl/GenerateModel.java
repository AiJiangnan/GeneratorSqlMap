package com.ajn.mybatis.generator.api.generate.impl;

import java.io.File;
import java.util.List;

import com.ajn.mybatis.generator.api.generate.GenerateFile;
import com.ajn.mybatis.generator.config.JdbcConfiguration;
import com.ajn.mybatis.generator.config.XmlConfiguration;
import com.ajn.mybatis.generator.config.impl.JdbcConfigurationImpl;
import com.ajn.mybatis.generator.config.impl.XmlConfigurationImpl;
import com.ajn.mybatis.generator.constants.Template;
import com.ajn.mybatis.generator.model.OutputPath;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.template.PojoTemplate;
import com.ajn.mybatis.generator.template.impl.PojoTemplateImpl;
import com.ajn.mybatis.generator.utils.FileUtil;
import com.ajn.mybatis.generator.utils.NameUtil;

public class GenerateModel implements GenerateFile {

	private XmlConfiguration xmlConfig = new XmlConfigurationImpl();
	private JdbcConfiguration jdbcConfig = new JdbcConfigurationImpl();
	private PojoTemplate modelTemplate = new PojoTemplateImpl();

	@Override
	public void generateFile() {
		List<Tables> tables = xmlConfig.getTables();

		String modelDirPath = NameUtil.packageToDir(xmlConfig.getOutputPath().getModelPath().get("targetPackage"));
		String modelProPath = xmlConfig.getOutputPath().getModelPath().get("targetProject");

		for (Tables table : tables) {
			genOneFile(modelProPath + modelDirPath, table);
		}
	}

	private void genOneFile(String dirName, Tables table) {
		List<TableProp> list = jdbcConfig.getTables(table.getTableName());
		String fileName = String.format(Template.JAVA_FILE_NAME, NameUtil.bigHumpName(table.getTableName()));
		OutputPath outputPath = xmlConfig.getOutputPath();
		String result = modelTemplate.genModel(outputPath, table, list);
		File file = FileUtil.newFile(dirName, fileName);
		FileUtil.writeFile(file, result);
	}

}
