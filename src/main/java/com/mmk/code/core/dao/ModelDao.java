package com.mmk.code.core.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.code.core.condition.ModelCondition;
import com.mmk.code.core.model.Model;
/**
*@Title: ModelDao
*@Description: 实体模型 数据持久层接口
*@author code generator
*@version 1.0
*@date 2016-07-19 15:26:10
* Modified By
* Modified Date
*/
public interface ModelDao extends SpringDataQueryDao<Model>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param model Model类
     * @param page 传入的分页对象
     * @return Page<Model> 查询的结果集
     * @author code generator
     * @date 2016-07-19 15:26:10
     * 
     */
    Page<Model> list(ModelCondition model,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param bean Model类
     * @return List<Model> 查询的结果集
     * @author code generator
     * @date 2016-07-19 15:26:10
     */
    List<Model> list(ModelCondition model);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param model Model类
     * @param page 传入的分页对象
     * @return Page<Model> 查询的结果集
     * @author code generator
     * @date 2016-07-19 15:26:10
     * 
     */
    Page< Map<String,Object>> listBySql(ModelCondition model,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Model 中的某个字段
     * @return Model 返回符合条件的结果，如果没有返回null
     * @author code generator
     * @date 2016-07-19 15:26:10
     * 
     */
    Model findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Model 中的某个字段
     * @return List<Model> 返回符合条件的所有结果
     * @author code generator
     * @date 2016-07-19 15:26:10
     * 
     */
    List<Model> findAllBy(String field,Object value);
    
    /**
     * 根据项目信息获得对应的项目模块配置信息
     * @param projectId
     * @param db
     * @param table
     * @return 对应的模型
     */
	Model findBy(Long projectId, String table);
    
    

}