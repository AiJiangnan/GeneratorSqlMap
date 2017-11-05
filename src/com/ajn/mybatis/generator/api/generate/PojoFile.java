package com.ajn.mybatis.generator.api.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.ajn.mybatis.generator.api.jdbc.Jdbc;
import com.ajn.mybatis.generator.model.TableProp;

public class PojoFile {

	public static void generatePojo() throws Exception {
		List<TableProp> table = Jdbc.getTable();
		StringBuilder sb = new StringBuilder();
		File file = new File("./src/Hello.java");
		if (!file.exists())
			file.createNewFile();
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		BufferedWriter writer = new BufferedWriter(osw);
		// sb.append("package com.ajn.pojo;\n");
		sb.append("public class Hello{\n");
		sb.append("\n");
		for (TableProp tableProp : table) {
			sb.append("\tprivate " + tableProp.getColumnClassName() + " " + tableProp.getColumnName() + ";\n");
		}
		sb.append("\n");
		sb.append("}");
		writer.write(sb.toString());
		writer.close();
		osw.close();
	}

}
