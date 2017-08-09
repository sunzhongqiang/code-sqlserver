package com.mmk.code.database.service;

import java.util.List;
import java.util.Map;

import com.mmk.code.database.model.Db;
import com.mmk.gene.service.BaseService;

/**
*@Title: DbService
*@Description: 数据库 业务服务层接口
*@author code generator
*@version 1.0
*@date 2016-07-19 17:14:33
*/
public interface DbService extends BaseService<Db, Long> {
	/**
	 * 遍历数据库中的所有数据库
	 * @return 数据库列表
	 */
	List<Map<String,Object>> dbList();
}