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
import com.ajn.mybatis.generator.template.ModelTemplate;
import com.ajn.mybatis.generator.template.impl.ModelTemplateImpl;
import com.ajn.mybatis.generator.utils.FileUtil;
import com.ajn.mybatis.generator.utils.NameUtil;

/**
 * 生成实体类文件的实现类
 * 
 * @author 艾江南
 *
 */
public class GenerateModel implements GenerateFile {

	private XmlConfiguration xmlConfig = new XmlConfigurationImpl();
	private JdbcConfiguration jdbcConfig = new JdbcConfigurationImpl();
	private ModelTemplate modelTemplate = new ModelTemplateImpl();

	@Override
	public void generateFile() {
		List<Tables> tables = xmlConfig.getTables();

		String modelDirPath = NameUtil.packageToDir(xmlConfig.getOutputPath().getModelPath().get("targetPackage"));
		String modelProPath = xmlConfig.getOutputPath().getModelPath().get("targetProject");

		for (Tables table : tables)
			genOneFile(modelProPath + modelDirPath, table);
	}

	private void genOneFile(String dirName, Tables table) {
		List<TableProp> list = jdbcConfig.getTables(table.getTableName());
		String fileName = String.format(Constants.JAVA_FILE_NAME, NameUtil.bigHumpName(table.getTableName()));
		String modelPakPath = xmlConfig.getOutputPath().getModelPath().get("targetPackage");
		String result = modelTemplate.genModel(modelPakPath, table, list);
		File file = FileUtil.newFile(dirName, fileName);
		FileUtil.writeFile(file, result);
	}

}
