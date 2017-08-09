package com.mmk.code.core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.code.core.condition.FieldCondition;
import com.mmk.code.core.dao.FieldDao;
import com.mmk.code.core.model.Field;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
*@Title: FieldDaoImpl
*@Description: 字段 数据持久层接口实现
*@author code generator
*@version 1.0
*@date 2016-07-22 09:49:51
*/
@Repository
public class FieldDaoImpl extends SpringDataQueryDaoImpl<Field> implements FieldDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public FieldDaoImpl(){
        super(Field.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param modelFieldCondition类
     * @param page 传入的分页对象
     * @return Page<Field> 查询的结果集
     * @author code generator
     * @date 2016-07-22 09:49:51
     */
    @Override 
    public Page<Field> list(FieldCondition fieldCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Field model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Field> list(FieldCondition fieldCondition){
        StringBuffer sb=new StringBuffer("select model from Field model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(FieldCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,model_id,columnName,field,comment,type,nullable,length,exists,find_by,find_all_by,list_show,match,validate,input_type from field  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Field findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Field model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Field> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Field> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Field model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public Field findByModelIdAndColumn(Long modelId, String columnName) {
		StringBuffer sb=new StringBuffer("select model from Field model  where model.modelId = :modelId and model.columnName = :columnName ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("modelId",modelId);
        params.put("columnName",columnName);
        List<Field> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
	}
    
    
}