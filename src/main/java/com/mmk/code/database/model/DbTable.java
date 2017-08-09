package com.mmk.code.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*@Title: Table
*@Description: 表 数据领域模型
*@author code generator
*@version 1.0
*@date 2016-07-19 17:15:43
*/
@Entity
@Table(name = "db_table")
public class DbTable {
    /**
     * 主键
     */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 表名
     */
    @Column(name="table_name")
    private String tableName;

    /**
     * 数据库
     */
    @Column(name="table_schema")
    private String tableSchema;


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
	* @return tableName ：表名
	*/
    public String getTableName() {
        return tableName;
    }
    /** 
    *@param tableName 设置表名 
    */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /** 
	* @return tableSchema ：数据库
	*/
    public String getTableSchema() {
        return tableSchema;
    }
    /** 
    *@param tableSchema 设置数据库 
    */
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }


}