package com.mmk.code.core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.code.core.condition.ProjectCondition;
import com.mmk.code.core.dao.ProjectDao;
import com.mmk.code.core.model.Project;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
*@Title: ProjectDaoImpl
*@Description: 项目 数据持久层接口实现
*@author code generator
*@version 1.0
*@date 2016-07-19 14:16:56
*/
@Repository
public class ProjectDaoImpl extends SpringDataQueryDaoImpl<Project> implements ProjectDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public ProjectDaoImpl(){
        super(Project.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param modelProjectCondition类
     * @param page 传入的分页对象
     * @return Page<Project> 查询的结果集
     * @author code generator
     * @date 2016-07-19 14:16:56
     */
    @Override 
    public Page<Project> list(ProjectCondition projectCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Project model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Project> list(ProjectCondition projectCondition){
        StringBuffer sb=new StringBuffer("select model from Project model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(ProjectCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,project_name,comment,database_name,path,group_package,description from project  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Project findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Project model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Project> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Project> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Project model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}