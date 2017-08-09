package com.mmk.code.core.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.code.common.SessionUtils;
import com.mmk.code.core.condition.BuildData;
import com.mmk.code.core.model.Field;
import com.mmk.code.core.model.Model;
import com.mmk.code.core.model.Project;
import com.mmk.code.core.service.CodeBuilderService;
import com.mmk.code.core.service.FieldService;
import com.mmk.code.core.service.ModelService;
import com.mmk.code.core.service.ProjectService;

@RestController
public class CodeBuilderController {
	
	@Resource
	private CodeBuilderService builder;
	@Resource 
	private ProjectService projectService;
	
	@Resource 
	private ModelService modelService;
	@Resource 
	private FieldService fieldService;

	@RequestMapping("/code/builde")
	@ResponseBody
	public String codeBuilder(@RequestBody BuildData data){
		
		//saveData(data);
		String template = StringUtils.trimToEmpty(data.getProject().getTemplate());
		
		return builder.buildAllCode(template,data);
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping("/code/save")
	@ResponseBody
	public String saveData(@RequestBody BuildData data){
		Project project = projectService.save(data.getProject());
		Model model = data.getModel();
		model.setProjectId(project.getId());
		model = modelService.save(model);
		List<Field> fieldList = data.getFieldList();
		for (Field field : fieldList) {
			field.setModelId(model.getId());
			fieldService.save(field);
		}
		return "SUCCESS";
	}
	
	@RequestMapping("/code/preview")
	public Map<String,Object> codePreview(@RequestBody BuildData data){
		
		String template = StringUtils.trimToEmpty(data.getProject().getTemplate());
		
		
		String modelcode = builder.buildModel(template,data);
		String condition = builder.buildCondition(template,data);
		String repository = builder.buildRepository(template,data);
		String dao = builder.buildDao(template,data);
		String daoImpl = builder.buildDaoImpl(template,data);
		String service = builder.buildService(template,data);
		String serviceImpl = builder.buildServiceImpl(template,data);
		String controller = builder.buildController(template,data);
		
		//页面部分生成
		
		String list = builder.buildList(template,data);
		String form = builder.buildForm(template,data);
		String details = builder.buildDetails(template,data);
		
		//JS部分
		String listjs = builder.buildListJs(template,data);
		String formjs = builder.buildFormJs(template,data);
		String detailsjs = builder.buildDetailsJs(template,data);
		
		HttpSession session = SessionUtils.getSession();
		
		session.setAttribute("model", StringEscapeUtils.escapeHtml(modelcode));
		session.setAttribute("condition", StringEscapeUtils.escapeHtml(condition));
		session.setAttribute("repository", StringEscapeUtils.escapeHtml(repository));
		session.setAttribute("dao", StringEscapeUtils.escapeHtml(dao));
		session.setAttribute("daoImpl", StringEscapeUtils.escapeHtml(daoImpl));
		session.setAttribute("service", StringEscapeUtils.escapeHtml(service));
		session.setAttribute("serviceImpl", StringEscapeUtils.escapeHtml(serviceImpl));
		session.setAttribute("controller", StringEscapeUtils.escapeHtml(controller));
		//页面部分
		session.setAttribute("list", StringEscapeUtils.escapeHtml(list));
		session.setAttribute("form", StringEscapeUtils.escapeHtml(form));
		session.setAttribute("details", StringEscapeUtils.escapeHtml(details));
		
		//js部分预览代码
		session.setAttribute("listjs",StringEscapeUtils.escapeHtml(listjs));
		session.setAttribute("formjs",StringEscapeUtils.escapeHtml(formjs));
		session.setAttribute("detailsjs",StringEscapeUtils.escapeHtml(detailsjs));
		
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("success", true);
		return result  ;
	}
	
	@RequestMapping("/code/preview/{code}")
	public ModelAndView codePreviewCode(@PathVariable String code){
		ModelAndView view = new ModelAndView("preview");
		view.addObject("code",SessionUtils.getSession().getAttribute(code));
		return view ;
	}
	
	@RequestMapping("/code/previewHtml/{code}")
	public ModelAndView codePreviewHtml(@PathVariable String code){
		ModelAndView view = new ModelAndView("previewhtml");
		view.addObject("code",SessionUtils.getSession().getAttribute(code));
		return view ;
	}
	
	
	
}
