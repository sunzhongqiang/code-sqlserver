package com.mmk.code.database.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmk.code.common.PropertyNameTools;
import com.mmk.code.database.dao.TableDao;
import com.mmk.code.database.dao.TableRepository;
import com.mmk.code.database.model.DbTable;
import com.mmk.code.database.service.TableService;
import com.mmk.gene.service.impl.BaseServiceImpl;
/**
*@Title: TableServiceImpl
*@Description: 表 业务服务层实现
*@author code generator
*@version 1.0
*@date 2016-07-19 17:15:43
*/
@Service
public class TableServiceImpl extends BaseServiceImpl<DbTable, Long> implements TableService {

	private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private TableDao tableDao;
    
    @Autowired
    public TableServiceImpl(TableRepository repository) {
    	super(repository);
    }

    @Override
	public List<Map<String,Object>> findAllByDb(String name) {
		return tableDao.findAll(name);
	}

	@Override
	public List<Map<String, Object>> showDetails(String db, String table) {
		List<Map<String, Object>> columnList = tableDao.showColumn(db, table);
		Map<String, Object> tableInfo = tableDao.tableInfo(db, table);
		String pk = MapUtils.getString(tableInfo, "COLUMN_NAME");
		for (Map<String, Object> map : columnList) {
			map.put("type", PropertyNameTools.changeType(MapUtils.getString(map, "DATA_TYPE")));
			map.put("field", PropertyNameTools.column2Field(MapUtils.getString(map, "columnName")));
			map.put("listShow", true);
			map.put("matchType", "none");
			map.put("id", "");
			
			if(MapUtils.getString(map, "columnName").equals(pk)){
				map.put("isPk", "Y");
			}else{
				map.put("isPk", "N");
			}
			
			map.put("columnName", MapUtils.getString(map, "columnName").toLowerCase());
			
			
			if(MapUtils.getString(map, "nullable", "Y").equals("Y")){
				map.put("nullable", true);
			}else{
				map.put("nullable", false);
			}
		}
		return columnList;
	}

	@Override
	public Map<String, Object> tableComment(String db, String table) {
		return tableDao.tableInfo(db,table);
	}

	@Override
	public List<Map<String, Object>> showColumnComment(String db, String table) {
		return tableDao.showColumnComment(db,table);
	}
}