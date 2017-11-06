package main;

import com.ajn.mybatis.generator.config.XmlConfiguration;
import com.ajn.mybatis.generator.config.impl.XmlConfigurationImpl;
import com.ajn.mybatis.generator.model.DataSource;
import com.ajn.mybatis.generator.model.OutputPath;

public class Main {

	public static void main(String[] args) {
		XmlConfiguration config = new XmlConfigurationImpl();
		DataSource dateSource = config.getDataSource();
		OutputPath outputPath = config.getOutputPath();
		System.out.println(dateSource.getUsername());
		System.out.println(outputPath.getModelPath());
	}

}
