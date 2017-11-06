package com.ajn.mybatis.generator.config;

import java.util.List;

import com.ajn.mybatis.generator.model.DataSource;
import com.ajn.mybatis.generator.model.OutputPath;
import com.ajn.mybatis.generator.model.Tables;

public interface XmlConfiguration {

	DataSource getDataSource();

	OutputPath getOutputPath();

	List<Tables> getTables();

}
