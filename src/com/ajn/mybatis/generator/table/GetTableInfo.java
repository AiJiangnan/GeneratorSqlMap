package com.ajn.mybatis.generator.table;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ajn.mybatis.generator.api.config.JdbcConfig;

public class GetTableInfo {

    public static void main(String[] args) {
        JdbcConfig config = JdbcConfig.getInstance();
        Connection conn = config.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        String[] tables = {
                "t_apply_bill_info_sd"
        };

        for (String string : tables) {
            getTableInfo(conn, string, stat, rs);
        }
        System.out.println(tables.length);
        config.closeConnection(conn, stat, rs);
    }

    private static void getTableInfo(Connection conn, String tableName, PreparedStatement stat, ResultSet rs) {
        File file = new File("F:/database.csv");
        String sql = "SHOW FULL FIELDS FROM " + tableName;
        String head = "字段,数据类型,为空,描述,取值\r\n";
        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            String result = tableName + "\r\n";
            result += head;
            while (rs.next()) {
                String field = rs.getString("Field");
                String type = rs.getString("Type");
                String isNull = rs.getString("Null");
                String comment = rs.getString("Comment");
                TableInfo tableInfo = new TableInfo(field, type, isNull, comment);
                result += tableInfo.toString() + "\r\n";
            }
            writeFile(file, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(File file, String str) {
        OutputStreamWriter osw = null;
        BufferedWriter writer = null;
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            osw = new OutputStreamWriter(new FileOutputStream(file, true), "GB2312");
            writer = new BufferedWriter(osw);
            writer.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
