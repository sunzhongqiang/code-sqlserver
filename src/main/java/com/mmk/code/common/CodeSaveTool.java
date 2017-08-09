package com.mmk.code.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CodeSaveTool {

	public static void save(String projectPath,String packagePath,String javaname,String code ) throws IOException{
		String pp = packagePath.replace(".", File.separator);
		StringBuilder path = new StringBuilder(projectPath);
		if(!projectPath.endsWith(File.separator)){
			path.append(File.separator);
		}
		path.append(pp);
		String pathVar = path.toString();
		if(Files.notExists(Paths.get(pathVar ))){
			Files.createDirectories(Paths.get(pathVar));
		}
		Files.deleteIfExists(Paths.get(pathVar+File.separator+javaname));
		Files.write(Paths.get(pathVar+File.separator+javaname), code.getBytes(),StandardOpenOption.CREATE);
	}

	/**
	 * 保存java代码部分
	 * @param path 保存路径
	 * @param packagePath 包路径
	 * @param name 文件名 
	 * @param code 代码内容
	 * @throws IOException IO异常 
	 */
	public static void saveCode(String path, String packagePath, String name, String code) throws IOException {
		save(path+"/src/main/java",packagePath,name,code);
	}

	/**
	 * 保存页面模板
	 * @param path 保存路径
	 * @param packagePath 包路径
	 * @param name 文件名 
	 * @param code 代码内容
	 * @throws IOException IO异常 
	 */
	public static void saveTemplates(String path, String packagePath, String name, String code) throws IOException {
		save(path+"/src/main/resources/templates",packagePath,name,code);
	}
	
	public static void saveJs(String path, String packagePath, String name, String code) throws IOException {
		save(path+"/src/main/resources/static/js",packagePath,name,code);
	}
}
