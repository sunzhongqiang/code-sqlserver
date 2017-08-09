package com.mmk.code.core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.code.core.condition.ModelCondition;
import com.mmk.code.core.dao.ModelDao;
import com.mmk.code.core.model.Model;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
*@Title: ModelDaoImpl
*@Description: 实体模型 数据持久层接口实现
*@author code generator
*@version 1.0
*@date 2016-07-19 15:26:10
*/
@Repository
public class ModelDaoImpl extends SpringDataQueryDaoImpl<Model> implements ModelDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public ModelDaoImpl(){
        super(Model.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param modelModelCondition类
     * @param page 传入的分页对象
     * @return Page<Model> 查询的结果集
     * @author code generator
     * @date 2016-07-19 15:26:10
     */
    @Override 
    public Page<Model> list(ModelCondition modelCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Model model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Model> list(ModelCondition modelCondition){
        StringBuffer sb=new StringBuffer("select model from Model model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(ModelCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,project_id,model,comment,tableName,package_name,author from model  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Model findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Model model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Model> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Model> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Model model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public Model findBy(Long projectId, String tableName) {
		 StringBuffer sb=new StringBuffer("select model from Model model  where model.projectId = :projectId ");
		 sb.append(" and model.tableName = :tableName");
         Map<String,Object> params = new HashMap<String,Object>();
         params.put("projectId", projectId);
         params.put("tableName", tableName);
         List<Model> result = queryByJpql(sb.toString(), params,0l,1l);
         return result.isEmpty() ? null : result.get(0);
	}
    
    
}