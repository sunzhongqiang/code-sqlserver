package com.mmk.code.database.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmk.code.database.dao.DbDao;
import com.mmk.code.database.dao.DbRepository;
import com.mmk.code.database.model.Db;
import com.mmk.code.database.service.DbService;
import com.mmk.gene.service.impl.BaseServiceImpl;
/**
*@Title: DbServiceImpl
*@Description: 数据库 业务服务层实现
*@author code generator
*@version 1.0
*@date 2016-07-19 17:14:33
*/
@Service
public class DbServiceImpl extends BaseServiceImpl<Db, Long> implements DbService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private DbDao dbDao;
    
    /**
    *构造方法
    */
    @Autowired
    public DbServiceImpl( DbRepository dbRepository) {
        super(dbRepository);
    }

    @Override
	public List<Map<String,Object>> dbList() {
    	log.info("遍历所有的数据库");
		return dbDao.listDb();
	}
}