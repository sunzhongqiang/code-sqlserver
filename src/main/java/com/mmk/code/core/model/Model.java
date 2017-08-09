package com.mmk.code.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mmk.code.common.PropertyNameTools;

import javax.persistence.Column;

/**
*@Title: Model
*@Description: 实体模型 数据领域模型
*@author code generator
*@version 1.0
*@date 2016-07-19 15:26:10
*/
@Entity
@Table(name = "db_model")
public class Model {
    /**
     * 模型ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 项目ID
     */
    @Column(name="project_id")
    private Long projectId;

    /**
     * 名称
     */
    @Column(name="model")
    private String model;

    /**
     * 备注
     */
    @Column(name="comment")
    private String comment;

    /**
     * 对应的表
     */
    @Column(name="table_name")
    private String tableName;

    /**
     * 包名
     */
    @Column(name="package_name")
    private String packageName;
    
    /**
     * 项目包名
     */
    @Column(name="module_package")
    private String modulePackage;

    /**
     * 作者
     */
    @Column(name="author")
    private String author;
    
    
    
    @Column(name="description")
    private String description;


    /** 
	* @return id ：模型ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置模型ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return projectId ：项目ID
	*/
    public Long getProjectId() {
        return projectId;
    }
    /** 
    *@param projectId 设置项目ID 
    */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /** 
	* @return model ：名称
	*/
    public String getModel() {
        return model;
    }
    
    public String getModelL(){
    	return PropertyNameTools.firstLetterLowerCase(model);
    }
    /** 
    *@param model 设置名称 
    */
    public void setModel(String model) {
        this.model = model;
    }

    /** 
	* @return comment ：备注
	*/
    public String getComment() {
        return comment;
    }
    /** 
    *@param comment 设置备注 
    */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /** 
	* @return table ：对应的表
	*/
    public String getTableName() {
        return tableName;
    }
    /** 
    *@param table 设置对应的表 
    */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /** 
	* @return packageName ：包名
	*/
    public String getPackageName() {
        return packageName;
    }
    /** 
    *@param packageName 设置包名 
    */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /** 
	* @return author ：作者
	*/
    public String getAuthor() {
        return author;
    }
    /** 
    *@param author 设置作者 
    */
    public void setAuthor(String author) {
        this.author = author;
    }
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModulePackage() {
		return modulePackage;
	}
	public void setModulePackage(String modulePackage) {
		this.modulePackage = modulePackage;
	}


}