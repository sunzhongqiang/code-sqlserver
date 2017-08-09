package com.mmk.code.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mmk.code.common.PropertyNameTools;

import javax.persistence.Column;

/**
*@Title: Field
*@Description: 字段 数据领域模型
*@author code generator
*@version 1.0
*@date 2016-07-22 09:49:51
*/
@Entity
@Table(name = "field")
public class Field {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 模型id
     */
    @Column(name="model_id")
    private Long modelId;
    
    @Transient
    private String isPk;

    /**
     * 表栏目
     */
    @Column(name="column_name")
    private String columnName;

    /**
     * 表字段
     */
    @Column(name="field")
    private String field;

    /**
     * 注释
     */
    @Column(name="comment")
    private String comment;

    /**
     * 字段类型
     */
    @Column(name="type")
    private String type;

    /**
     * 可否为空
     */
    @Column(name="nullable")
    private Boolean nullable;

    /**
     * 长度
     */
    @Column(name="length")
    private Long length;

    /**
     * 存在方法
     */
    @Column(name="exists_method")
    private Boolean existsMethod;

    /**
     * findBy方法
     */
    @Column(name="find_by")
    private Boolean findBy;

    /**
     * findAllBy方法
     */
    @Column(name="find_all_by")
    private Boolean findAllBy;

    /**
     * 列表显示
     */
    @Column(name="list_show")
    private Boolean listShow;

    /**
     * 查询类型
     */
    @Column(name="match_type")
    private String matchType;

    /**
     * 验证类型
     */
    @Column(name="validate")
    private String validate;

    /**
     * 编辑input类型
     */
    @Column(name="input_type")
    private String inputType;


    /** 
	* @return id ：自增主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置自增主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return modelId ：模型id
	*/
    public Long getModelId() {
        return modelId;
    }
    /** 
    *@param modelId 设置模型id 
    */
    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    /** 
	* @return column ：表栏目
	*/
    public String getColumnName() {
        return columnName;
    }
    /** 
    *@param column 设置表栏目 
    */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /** 
	* @return field ：表字段
	*/
    public String getField() {
    	return field;
    }
    
    public String getFieldUp() {
        return PropertyNameTools.firstLetterUpperCase(field);
    }
    /** 
    *@param field 设置表字段 
    */
    public void setField(String field) {
        this.field = field;
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
	* @return type ：字段类型
	*/
    public String getType() {
        return type;
    }
    /** 
    *@param type 设置字段类型 
    */
    public void setType(String type) {
        this.type = type;
    }

    /** 
	* @return nullable ：可否为空
	*/
    public Boolean getNullable() {
        return nullable;
    }
    /** 
    *@param nullable 设置可否为空 
    */
    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    /** 
	* @return length ：长度
	*/
    public Long getLength() {
        return length;
    }
    /** 
    *@param length 设置长度 
    */
    public void setLength(Long length) {
        this.length = length;
    }

    /** 
	* @return exists ：存在方法
	*/
    public Boolean getExistsMethod() {
        return existsMethod;
    }
    /** 
    *@param exists 设置存在方法 
    */
    public void setExistsMethod(Boolean existsMethod) {
        this.existsMethod = existsMethod;
    }

    /** 
	* @return findBy ：findBy方法
	*/
    public Boolean getFindBy() {
        return findBy;
    }
    /** 
    *@param findBy 设置findBy方法 
    */
    public void setFindBy(Boolean findBy) {
        this.findBy = findBy;
    }

    /** 
	* @return findAllBy ：findAllBy方法
	*/
    public Boolean getFindAllBy() {
        return findAllBy;
    }
    /** 
    *@param findAllBy 设置findAllBy方法 
    */
    public void setFindAllBy(Boolean findAllBy) {
        this.findAllBy = findAllBy;
    }

    /** 
	* @return listShow ：列表显示
	*/
    public Boolean getListShow() {
        return listShow;
    }
    /** 
    *@param listShow 设置列表显示 
    */
    public void setListShow(Boolean listShow) {
        this.listShow = listShow;
    }

    /** 
	* @return match ：查询类型
	*/
    public String getMatchType() {
        return matchType;
    }
    /** 
    *@param match 设置查询类型 
    */
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    /** 
	* @return validate ：验证类型
	*/
    public String getValidate() {
        return validate;
    }
    /** 
    *@param validate 设置验证类型 
    */
    public void setValidate(String validate) {
        this.validate = validate;
    }

    /** 
	* @return inputType ：编辑input类型
	*/
    public String getInputType() {
        return inputType;
    }
    /** 
    *@param inputType 设置编辑input类型 
    */
    public void setInputType(String inputType) {
        this.inputType = inputType;
    }
	public String getIsPk() {
		return isPk;
	}
	public void setIsPk(String isPk) {
		this.isPk = isPk;
	}


}