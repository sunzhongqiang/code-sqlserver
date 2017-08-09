package com.mmk.code.core.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.mmk.code.common.CodeSaveTool;
import com.mmk.code.common.PropertyNameTools;
import com.mmk.code.common.TemplateTool;
import com.mmk.code.core.condition.BuildData;
import com.mmk.code.core.model.Field;
import com.mmk.code.core.service.CodeBuilderService;
import com.mmk.code.core.service.FieldService;

@Service
public class CodeBuilderServiceImpl implements CodeBuilderService {
	
	@Resource
	private FieldService fieldService;
	
	/**
	 * 获得主键类型
	 * @param list
	 * @return
	 */
	private String getPKType(List<Field> list) {
		String pk = "Long";
		for(Field field : list){
			if("Y".equals(field.getIsPk())){
				pk = field.getType();
				break;
			}
		}
		return pk;
	}
	
	/**
	 * 获得主键field并首字母大写返回
	 * @param list
	 * @return
	 */
	private String getPKFieldUp(List<Field> list) {
		String fieldUp = "Id";
		for(Field field : list){
			if("Y".equals(field.getIsPk())){
				fieldUp = PropertyNameTools.firstLetterUpperCase(field.getField());
				break;
			}
		}
		return fieldUp;
	}
	
	/**
	 * 获得主键字段
	 * @param fieldList
	 * @return
	 */
	private Object getPKField(List<Field> fieldList) {
		String fieldUp = "id";
		for(Field field : fieldList){
			if("Y".equals(field.getIsPk())){
				fieldUp = field.getField();
				break;
			}
		}
		return fieldUp;
	}
	
	private Map<String, Object> modelImport(List<Field> fieldList) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		for (Field field : fieldList) {
			if ("String".equals(field.getType()) || "Long".equals(field.getType()) || "Integer".equals(field.getType())
					|| "Float".equals(field.getType()) || "Double".equals(field.getType())) 
			{
				continue;
			}
			if("Date".equals(field.getType())){
				if("Date".equals(field.getType())){
					result.put("Date","import java.util.Date;");
					result.put("Temporal","import javax.persistence.Temporal;");
					result.put("TemporalType","import javax.persistence.TemporalType;");
				}
			}
			
		}
		return result;
	}
	
	private String templatePath(String template,String type,String name){
		StringBuilder result = new StringBuilder("templates/");
		if(StringUtils.isNotBlank(template)){
			result.append(template);
			result.append("/");
		}
		result.append(type);
		result.append("/");
		result.append(name);
		result.append(".html");
		return result.toString();
	}


	@Override
	public String buildModel(String template,BuildData data) {
		Map<String, Object> importList = modelImport(data.getFieldList());

		TemplateTool tool = new TemplateTool(templatePath(template,"code","model"));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		tool.put("importList", importList);
		return tool.getResult();
	}
	
	@Override
	public String buildCondition(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"code","condition"));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}

	@Override
	public String buildRepository(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"code","repository"));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		String pk ="Long";
		pk = getPKType(data.getFieldList());
		tool.put("PK", pk);
		return tool.getResult();
	}

	@Override
	public String buildDao(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"code","dao"));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("modelName", PropertyNameTools.firstLetterLowerCase(data.getModel().getModel()));
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}

	@Override
	public String buildDaoImpl(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"code","daoImpl"));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		tool.put("modelName", PropertyNameTools.firstLetterLowerCase(data.getModel().getModel()));
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}
	
	@Override
	public String buildService(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"code","service"));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		String pk ="Long";
		pk = getPKType(data.getFieldList());
		tool.put("PK", pk);
		return tool.getResult();
	}
	
	@Override
	public String buildServiceImpl(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"code","serviceImpl"));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		String pk ="Long";
		pk = getPKType(data.getFieldList());
		tool.put("PK", pk);
		return tool.getResult();
	}

	
	@Override
	public String buildController(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"code","controller"));
		tool.put("pkFieldUp", getPKFieldUp(data.getFieldList()));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}
	
	@Override
	public String buildList(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"page","list"));
		tool.put("pkFieldUp", getPKFieldUp(data.getFieldList()));
		tool.put("pkField", getPKField(data.getFieldList()));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}
	
	@Override
	public String buildForm(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"page","form"));
		tool.put("pkFieldUp", getPKFieldUp(data.getFieldList()));
		tool.put("pkField", getPKField(data.getFieldList()));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}

	@Override
	public String buildDetails(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"page","details"));
		tool.put("pkFieldUp", getPKFieldUp(data.getFieldList()));
		tool.put("pkField", getPKField(data.getFieldList()));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}

	@Override
	public String buildListJs(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"js","list"));
		tool.put("pkFieldUp", getPKFieldUp(data.getFieldList()));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}
	@Override
	public String buildFormJs(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"js","form"));
		tool.put("pkFieldUp", getPKFieldUp(data.getFieldList()));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}
	@Override
	public String buildDetailsJs(String template,BuildData data) {
		TemplateTool tool = new TemplateTool(templatePath(template,"js","details"));
		tool.put("pkFieldUp", getPKFieldUp(data.getFieldList()));
		tool.put("project", data.getProject());
		tool.put("model", data.getModel());
		tool.put("fieldList", data.getFieldList());
		tool.put("date",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return tool.getResult();
	}


	@Override
	public String buildAllCode(String template,BuildData data) {
		String modelcode =buildModel(template,data);
		String condition = buildCondition(template,data);
		String repository = buildRepository(template,data);
		String dao = buildDao(template,data);
		String daoImpl = buildDaoImpl(template,data);
		String service = buildService(template,data);
		String serviceImpl = buildServiceImpl(template,data);
		String controller = buildController(template,data);
		
		//页面部分生成
		
		String list = buildList(template,data);
		String form = buildForm(template,data);
		String details = buildDetails(template,data);
		
		//生成js部分
		String listjs = buildListJs(template,data);
		String formjs = buildFormJs(template,data);
		String detailsjs = buildDetailsJs(template,data);
		
		//保存代码到磁盘
		try {
			CodeSaveTool.saveCode(data.getProject().getPath(), data.getModel().getPackageName()+"."+data.getModel().getModulePackage()+".model",data.getModel().getModel()+".java", modelcode);
			CodeSaveTool.saveCode(data.getProject().getPath(), data.getModel().getPackageName()+"."+data.getModel().getModulePackage()+".condition",data.getModel().getModel()+"Condition.java", condition);
			CodeSaveTool.saveCode(data.getProject().getPath(), data.getModel().getPackageName()+"."+data.getModel().getModulePackage()+".dao",data.getModel().getModel()+"Repository.java", repository);
			CodeSaveTool.saveCode(data.getProject().getPath(), data.getModel().getPackageName()+"."+data.getModel().getModulePackage()+".dao",data.getModel().getModel()+"Dao.java", dao);
			CodeSaveTool.saveCode(data.getProject().getPath(), data.getModel().getPackageName()+"."+data.getModel().getModulePackage()+".dao.impl",data.getModel().getModel()+"DaoImpl.java", daoImpl);
			CodeSaveTool.saveCode(data.getProject().getPath(), data.getModel().getPackageName()+"."+data.getModel().getModulePackage()+".service",data.getModel().getModel()+"Service.java", service);
			CodeSaveTool.saveCode(data.getProject().getPath(), data.getModel().getPackageName()+"."+data.getModel().getModulePackage()+".service.impl",data.getModel().getModel()+"ServiceImpl.java", serviceImpl);
			CodeSaveTool.saveCode(data.getProject().getPath(), data.getModel().getPackageName()+"."+data.getModel().getModulePackage()+".web",data.getModel().getModel()+"Controller.java", controller);
			
			//页面部分
			CodeSaveTool.saveTemplates(data.getProject().getPath(), data.getModel().getModulePackage()+"."+ data.getModel().getModelL(),"list.html", list);
			CodeSaveTool.saveTemplates(data.getProject().getPath(), data.getModel().getModulePackage()+"."+ data.getModel().getModelL(),"form.html", form);
			CodeSaveTool.saveTemplates(data.getProject().getPath(), data.getModel().getModulePackage()+"."+ data.getModel().getModelL(),"details.html", details);
			
			//js部分
			CodeSaveTool.saveJs(data.getProject().getPath(), data.getModel().getModulePackage()+"."+ data.getModel().getModelL(),"list.js", listjs);
			CodeSaveTool.saveJs(data.getProject().getPath(), data.getModel().getModulePackage()+"."+ data.getModel().getModelL(),"form.js", formjs);
			CodeSaveTool.saveJs(data.getProject().getPath(), data.getModel().getModulePackage()+"."+ data.getModel().getModelL(),"details.js", detailsjs);
			
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "代码生成成功";
	}

	

	@Override
	public String addIFrame(String code) {
		StringBuilder html = new StringBuilder();
		html.append("<iframe src='/code/preview/"+code+"'></iframe>");
		return html.toString();
	}

}
