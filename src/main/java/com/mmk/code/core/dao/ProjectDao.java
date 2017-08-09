package com.mmk.code.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.code.core.condition.ProjectCondition;
import com.mmk.code.core.model.Project;
import com.mmk.gene.dao.SpringDataQueryDao;
/**
*@Title: ProjectDao
*@Description: 项目 数据持久层接口
*@author code generator
*@version 1.0
*@date 2016-07-19 14:16:56
* Modified By
* Modified Date
*/
public interface ProjectDao extends SpringDataQueryDao<Project>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param model Project类
     * @param page 传入的分页对象
     * @return Page<Project> 查询的结果集
     * @author code generator
     * @date 2016-07-19 14:16:56
     * 
     */
    Page<Project> list(ProjectCondition project,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param bean Project类
     * @return List<Project> 查询的结果集
     * @author code generator
     * @date 2016-07-19 14:16:56
     */
    List<Project> list(ProjectCondition project);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param model Project类
     * @param page 传入的分页对象
     * @return Page<Project> 查询的结果集
     * @author code generator
     * @date 2016-07-19 14:16:56
     * 
     */
    Page< Map<String,Object>> listBySql(ProjectCondition project,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Project 中的某个字段
     * @return Project 返回符合条件的结果，如果没有返回null
     * @author code generator
     * @date 2016-07-19 14:16:56
     * 
     */
    Project findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Project 中的某个字段
     * @return List<Project> 返回符合条件的所有结果
     * @author code generator
     * @date 2016-07-19 14:16:56
     * 
     */
    List<Project> findAllBy(String field,Object value);
    
    

}