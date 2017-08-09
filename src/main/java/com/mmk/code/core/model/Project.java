package com.mmk.code.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
*@Title: Project
*@Description: 项目 数据领域模型
*@author code generator
*@version 1.0
*@date 2016-07-19 14:16:55
*/
@Entity
@Table(name = "project")
public class Project {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 项目名称
     */
    @Column(name="project_name")
    private String projectName;

    /**
     * 注释
     */
    @Column(name="comment")
    private String comment;

    /**
     * 对应数据库
     */
    @Column(name="database_name")
    private String databaseName;
    
    /**
     * 要使用的代码模板
     */
    @Column(name="template")
    private String template;

    /**
     * 目录地址
     */
    @Column(name="path")
    private String path;

    /**
     * 组织包
     */
    @Column(name="group_package")
    private String groupPackage;
    
    
    /**
     * 模块包
     */
    @Column(name="module_package")
    private String modulePackage;

    /**
     * 项目描述
     */
    @Column(name="description")
    private String description;


    /** 
	* @return id ：ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return projectName ：项目名称
	*/
    public String getProjectName() {
        return projectName;
    }
    /** 
    *@param projectName 设置项目名称 
    */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /** 
	* @return comment ：注释
	*/
    public String getComment() {
        return comment;
    }
    /** 
    *@param comment 设置注释 
    */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /** 
	* @return databaseName ：对应数据库
	*/
    public String getDatabaseName() {
        return databaseName;
    }
    /** 
    *@param databaseName 设置对应数据库 
    */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    /** 
	* @return path ：目录地址
	*/
    public String getPath() {
        return path;
    }
    /** 
    *@param path 设置目录地址 
    */
    public void setPath(String path) {
        this.path = path;
    }

    /** 
	* @return groupPackage ：组织包
	*/
    public String getGroupPackage() {
        return groupPackage;
    }
    /** 
    *@param groupPackage 设置组织包 
    */
    public void setGroupPackage(String groupPackage) {
        this.groupPackage = groupPackage;
    }

    /** 
	* @return description ：项目描述
	*/
    public String getDescription() {
        return description;
    }
    /** 
    *@param description 设置项目描述 
    */
    public void setDescription(String description) {
        this.description = description;
    }
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getModulePackage() {
		return modulePackage;
	}
	public void setModulePackage(String modulePackage) {
		this.modulePackage = modulePackage;
	}
	
}