package com.mmk.code.database.service;

import java.util.List;
import java.util.Map;

import com.mmk.code.database.model.DbTable;
import com.mmk.gene.service.BaseService;

/**
*@Title: TableService
*@Description: 表 业务服务层接口
*@author code generator
*@version 1.0
*@date 2016-07-19 17:15:43
*/
public interface TableService extends BaseService<DbTable, Long> {
	/**
	 * 根据数据库返回数据库中的所有表
	 * @param name 数据库名
	 * @return 数据库中的所有表
	 */
	List<Map<String,Object>> findAllByDb(String name);

	/**
	 * 根据数据库和表，返回数据表中的所有字段
	 * @param db 数据库
	 * @param table 数据表
	 * @return 显示数据表中的所有字段
	 */
	List<Map<String,Object>> showDetails(String db, String table);
	
	/**
	 * 获取表的备注信息
	 * @param db 数据库
	 * @param table 表
	 * @return
	 */
	List<Map<String,Object>> showColumnComment(String db, String table);
	
	/**
	 * 根据数据库和数据库中的表，返回数据表的注释和其他表信息
	 * @param db
	 * @param table
	 * @return
	 */
	Map<String,Object> tableComment(String db, String table);
	
	
}