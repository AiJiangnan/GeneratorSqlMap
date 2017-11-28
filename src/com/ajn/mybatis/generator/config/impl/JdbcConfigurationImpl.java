package com.ajn.mybatis.generator.config.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ajn.mybatis.generator.api.config.JdbcConfig;
import com.ajn.mybatis.generator.config.JdbcConfiguration;
import com.ajn.mybatis.generator.model.TableProp;

public class JdbcConfigurationImpl implements JdbcConfiguration {

    private final JdbcConfig jdbcConfig = JdbcConfig.getInstance();

    @Override
    public List<TableProp> getTables(String tableName) {
        List<TableProp> list = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        Connection conn = jdbcConfig.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                TableProp tableProp = new TableProp();
                tableProp.setColumnName(metaData.getColumnName(i));
                String columnClassName = metaData.getColumnClassName(i);
                columnClassName = columnClassName.substring(columnClassName.lastIndexOf(".") + 1);
                if (columnClassName.equals("Timestamp")) {
                    columnClassName = "Date";
                }
                tableProp.setColumnClassName(columnClassName);
                list.add(tableProp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcConfig.closeConnection(conn, stat, rs);
        return list;
    }

}
