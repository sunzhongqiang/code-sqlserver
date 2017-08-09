package com.mmk.code.database.dao;

import java.util.List;
import java.util.Map;

import com.mmk.code.database.model.DbTable;
import com.mmk.gene.dao.SpringDataQueryDao;
/**
*@Title: TableDao
*@Description: 表 数据持久层接口
*@author code generator
*@version 1.0
*@date 2016-07-19 17:15:43
* Modified By
* Modified Date
*/
public interface TableDao extends SpringDataQueryDao<DbTable>{
    
	/**
	 * 获取系统中所有的表
	 * @return
	 */
	List<Map<String,Object>> findAll(String db);
	/**
	 * 显示所有表的字段新
	 * @param db
	 * @param table
	 * @return
	 */
	List<Map<String,Object>>  showColumn(String db,String table);
	/**
	 * 表信息
	 * @param db
	 * @param table
	 * @return
	 */
	Map<String, Object> tableInfo(String db, String table);
	/**
	 * 显示字段的备注
	 * @param db
	 * @param table
	 * @return
	 */
	List<Map<String, Object>> showColumnComment(String db, String table);
	/**
	 * 获得表的主键
	 * @param db
	 * @param table
	 * @return
	 */
	Map<String, Object> tablePK(String db, String table);
	
	
	
    

}