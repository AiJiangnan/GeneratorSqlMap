package com.ajn.mybatis.generator.api.generate;

import com.ajn.mybatis.generator.api.generate.impl.GenerateInterface;
import com.ajn.mybatis.generator.api.generate.impl.GenerateMapper;
import com.ajn.mybatis.generator.api.generate.impl.GenerateModel;

public class GenerateFactory {

	public GenerateFile getGenerateFile(String fileType) {
		if (fileType == null)
			return null;
		if (fileType.equalsIgnoreCase("MODEL"))
			return new GenerateModel();
		else if (fileType.equalsIgnoreCase("INTERFACE"))
			return new GenerateInterface();
		else if (fileType.equalsIgnoreCase("MAPPER"))
			return new GenerateMapper();
		return null;
	}

}
