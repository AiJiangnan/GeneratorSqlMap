package com.ajn.mybatis.generator.api.generate;

import com.ajn.mybatis.generator.api.generate.impl.GenerateModel;

public class GenerateFactory {

	public GenerateFile getGenerateFile(String fileType) {
		if (fileType == null)
			return null;
		if (fileType.equalsIgnoreCase("MODEL"))
			return new GenerateModel();
		return null;
	}

}
