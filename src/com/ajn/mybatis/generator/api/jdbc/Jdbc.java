package com.ajn.mybatis.generator.api.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ajn.mybatis.generator.config.XmlConfiguration;
import com.ajn.mybatis.generator.config.impl.XmlConfigurationImpl;
import com.ajn.mybatis.generator.model.DataSource;
import com.ajn.mybatis.generator.model.TableProp;

public class Jdbc {

	private static ResultSetMetaData metaData;
	private static Connection conn = null;

	static {
		XmlConfiguration config = new XmlConfigurationImpl();
		DataSource dataSource = config.getDataSource();
		String sql = "SELECT * FROM user";
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName(dataSource.getDriver());
			conn = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			metaData = rs.getMetaData();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stat.close();
				// conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<TableProp> getTable() throws Exception {
		List<TableProp> list = new ArrayList<>();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			TableProp tableProp = new TableProp();
			tableProp.setColumnName(metaData.getColumnName(i));
			String columnClassName = metaData.getColumnClassName(i);
			columnClassName = columnClassName.substring(columnClassName.lastIndexOf(".") + 1);
			tableProp.setColumnClassName(columnClassName);
			list.add(tableProp);
		}
		conn.close();
		return list;
	}

}
