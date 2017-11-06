package com.ajn.mybatis.generator.utils;

/**
 * 下划线驼峰等命名转换工具
 * 
 * @author 艾江南
 *
 */
public class NameUtil {

	/**
	 * firstShoppingDate --> first_shopping_date
	 * 
	 * @param name
	 * @return
	 */
	public static String underName(String name) {
		StringBuilder result = new StringBuilder();
		if (name == null || name.equals(""))
			return "";
		for (int i = 0, n = name.length(); i < n; i++) {
			String s = name.substring(i, i + 1);
			if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0)))
				result.append("_");
			result.append(s.toLowerCase());
		}
		return result.toString();
	}

	/**
	 * first_shopping_date --> firstShoppingDate
	 * 
	 * @param name
	 * @return
	 */
	public static String humpName(String name) {
		StringBuilder result = new StringBuilder();
		if (name == null || name.equals(""))
			return "";
		if (!name.contains("_"))
			return name.substring(0, 1).toLowerCase() + name.substring(1);
		String camels[] = name.split("_");
		for (String camel : camels) {
			if (camel.isEmpty())
				continue;
			if (result.length() == 0)
				result.append(camel.toLowerCase());
			else {
				result.append(camel.substring(0, 1).toUpperCase());
				result.append(camel.substring(1).toLowerCase());
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String[] str = { "riskCode", "riskCodeValue" };
		for (String string : str) {
			System.out.println(underName(string));
		}
	}

}
