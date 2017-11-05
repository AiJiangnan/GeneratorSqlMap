package main;

import com.ajn.mybatis.generator.api.generate.PojoFile;

public class Main {

	public static void main(String[] args) {
		try {
			PojoFile.generatePojo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
