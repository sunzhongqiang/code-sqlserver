package com.mmk.code.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
*@Title: Db
*@Description: 数据库 数据领域模型
*@author code generator
*@version 1.0
*@date 2016-07-19 17:14:33
*/
@Entity
@Table(name = "db")
public class Db {
    /**
     * 主键
     */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 数据库
     */
    @Column(name="schema_name")
    private String schemaName;


    /** 
	* @return id ：主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return schemaName ：数据库
	*/
    public String getSchemaName() {
        return schemaName;
    }
    /** 
    *@param schemaName 设置数据库 
    */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }


}