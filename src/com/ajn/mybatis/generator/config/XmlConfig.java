package com.ajn.mybatis.generator.config;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ajn.mybatis.generator.model.DataSource;
import com.ajn.mybatis.generator.model.OutputPath;

public class XmlConfig {

	private static Element root;

	static {
		File file = new File("generatorConfig.xml");
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read(file);
			root = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		Element jdbcConnection = root.element("jdbcConnection");
		String driver = jdbcConnection.attribute("driver").getStringValue();
		String url = jdbcConnection.attribute("url").getStringValue();
		String username = jdbcConnection.attribute("username").getStringValue();
		String password = jdbcConnection.attribute("password").getStringValue();
		return new DataSource(driver, url, username, password);
	}

	public static OutputPath getOutputPath() {
		Element model = root.element("javaModelGenerator");
		String modelPackage = model.attribute("targetPackage").getStringValue();
		String modelProject = model.attribute("targetProject").getStringValue();
		return new OutputPath(modelPackage, modelProject);
	};

}
