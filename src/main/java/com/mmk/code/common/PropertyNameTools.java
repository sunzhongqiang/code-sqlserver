package com.mmk.code.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class PropertyNameTools {
	
	public static Map<String,String> typeMap = new HashMap<String,String>();
	
	static{
		typeMap.put("TINYINT", "Long");
		typeMap.put("SMALLINT", "Long");
		typeMap.put("MEDIUMINT", "Long");
		typeMap.put("INTEGER", "Long");
		typeMap.put("BIGINT", "Long");
		typeMap.put("INT", "Long");
		typeMap.put("BIT", "Boolean");
		
		typeMap.put("FLOAT", "Double");
		typeMap.put("DOUBLE", "Double");
		typeMap.put("DECIMAL", "Double");
		
		typeMap.put("CHAR", "String");
		typeMap.put("VARCHAR", "String");
		typeMap.put("TINYBLOB", "String");
		typeMap.put("TINYTEXT", "String");
		typeMap.put("BLOB", "String");
		typeMap.put("TEXT", "String");
		typeMap.put("MEDIUMBLOB", "String");
		typeMap.put("MEDIUMTEXT", "String");
		typeMap.put("LOGNGBLOB", "String");
		typeMap.put("LONGTEXT", "String");
		typeMap.put("VARBINARY", "String");
		typeMap.put("BINARY", "String");

		typeMap.put("DATE", "Date");
		typeMap.put("TIME", "Date");
		typeMap.put("DATETIME", "Date");
		typeMap.put("TIMESTAMP", "Date");
		typeMap.put("YEAR", "Date");
		
	}
	
	public static String firstLetterUpperCase(String word){
		 if(StringUtils.isNotBlank(word)){
			 String firstLetter = StringUtils.substring(word, 0, 1);
			 word = StringUtils.replaceOnce(word, firstLetter, firstLetter.toUpperCase());
		 }
		return word;
	}
	
	public static String firstLetterLowerCase(String word){
		 if(StringUtils.isNotBlank(word)){
			 String firstLetter = StringUtils.substring(word, 0, 1);
			 word = StringUtils.replaceOnce(word, firstLetter, firstLetter.toLowerCase());
		 }
		return word;
	}


	public static String changeType(String key) {
		String type = typeMap.get(key.toUpperCase());
		if(type==null){
			type = "String";
		}
		return type;
	}


	public static String table2Model(String tableName) {
		return firstLetterUpperCase(sqlStringToClassString(tableName));
	}
	
	public static String column2Field(String columnName){
		return sqlStringToClassString(columnName);
	}
	
	public static String sqlStringToClassString(String sqlString){
		String base = sqlString.replaceAll("-", "_");
		String[] nameSplited = base.split("_");
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNoneBlank(base)){
			sb.append(nameSplited[0]);
			for (int i = 1; i < nameSplited.length; i++) {
				sb.append(firstLetterUpperCase(nameSplited[i]));
			}
		}
		return sb.toString();
	}

}
