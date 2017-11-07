package main;

import com.ajn.mybatis.generator.api.generate.GenerateFactory;
import com.ajn.mybatis.generator.api.generate.GenerateFile;

public class Main {

	public static void main(String[] args) {
		GenerateFactory factory = new GenerateFactory();
		GenerateFile generateFile = factory.getGenerateFile("MODEL");
		generateFile.generateFile();
		generateFile = factory.getGenerateFile("INTERFACE");
		generateFile.generateFile();
		generateFile = factory.getGenerateFile("MAPPER");
		generateFile.generateFile();
	}

}
