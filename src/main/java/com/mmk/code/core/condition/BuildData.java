package com.mmk.code.core.condition;

import java.util.List;

import com.mmk.code.core.model.Field;
import com.mmk.code.core.model.Model;
import com.mmk.code.core.model.Project;

public class BuildData {
	private Project project;
	private Model model;
	private List<Field> fieldList;
	
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public List<Field> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
}
