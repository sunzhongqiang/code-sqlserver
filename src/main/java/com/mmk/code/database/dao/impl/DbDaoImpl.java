package com.mmk.code.database.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.mmk.code.database.dao.DbDao;
import com.mmk.code.database.model.Db;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
*@Title: DbDaoImpl
*@Description: 数据库 数据持久层接口实现
*@author code generator
*@version 1.0
*@date 2016-07-19 17:14:33
*/
@Repository
public class DbDaoImpl extends SpringDataQueryDaoImpl<Db> implements DbDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public DbDaoImpl(){
        super(Db.class);
    }
    
    
    @Override
	public List<Map<String,Object>> listDb() {
		StringBuilder sql = new StringBuilder();
		//sql.append("select SCHEMA_NAME,true as isNode  ,true as leaf from information_schema.SCHEMATA where SCHEMA_NAME not  in('information_schema','mysql','performance_schema')");
		sql.append("SELECT Name as SCHEMA_NAME  ,1 as isNode  ,1 as leaf  FROM Master..SysDatabases where Name not in ('master','msdb') ORDER BY Name ");
		Query query = entityManager.createNativeQuery(sql.toString());
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);  
		return query.getResultList();
	}


    @Transactional
	@Override
	public void changeDB(String db) {
		Map<Integer, Object> params = new HashMap<Integer,Object>();
		executeNativeUpdate("Use "+db, params);
	}
    
    
}