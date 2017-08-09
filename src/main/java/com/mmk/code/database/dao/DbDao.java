package com.mmk.code.database.dao;

import java.util.List;
import java.util.Map;

import com.mmk.code.database.model.Db;
import com.mmk.gene.dao.SpringDataQueryDao;
/**
*@Title: DbDao
*@Description: 数据库 数据持久层接口
*@author code generator
*@version 1.0
*@date 2016-07-19 17:14:33
* Modified By
* Modified Date
*/
public interface DbDao extends SpringDataQueryDao<Db>{
    
    /**
	 * 遍历数据库的数据库
	 * @return
	 */
	List<Map<String,Object>> listDb();
	/**
	 * 切换数据库
	 * @param db
	 */
	void changeDB(String db);

}