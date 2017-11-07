package com.ajn.mybatis.generator.config;

import java.util.List;

import com.ajn.mybatis.generator.model.TableProp;

public interface JdbcConfiguration {

	List<TableProp> getTables(String tableName);

}
