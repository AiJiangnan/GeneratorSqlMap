package com.ajn.mybatis.generator.api.generate.impl;

import java.io.File;
import java.util.List;

import com.ajn.mybatis.generator.api.generate.GenerateFile;
import com.ajn.mybatis.generator.api.jdbc.Jdbc;
import com.ajn.mybatis.generator.config.XmlConfiguration;
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
	private PojoTemplate modelTemplate = new PojoTemplateImpl();

	@Override
	public void generateFile() {
		Tables table = xmlConfig.getTables().get(0);
		List<TableProp> list = null;
		try {
			list = Jdbc.getTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String modelDirPath = NameUtil.packageToDir(xmlConfig.getOutputPath().getModelPath().get("targetPackage"));
		String modelProPath = xmlConfig.getOutputPath().getModelPath().get("targetProject");
		String fileName = String.format(Template.JAVA_FILE_NAME, NameUtil.bigHumpName(table.getTableName()));
		File file = FileUtil.newFile(modelProPath + modelDirPath, fileName);
		OutputPath outputPath = xmlConfig.getOutputPath();
		String result = modelTemplate.genModel(outputPath, table, list);
		FileUtil.writeFile(file, result);
	}

}
