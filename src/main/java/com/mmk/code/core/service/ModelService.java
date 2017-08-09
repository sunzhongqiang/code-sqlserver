package com.mmk.code.core.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.code.core.model.Model;
import com.mmk.code.core.condition.ModelCondition;

/**
*@Title: ModelService
*@Description: 实体模型 业务服务层接口
*@author code generator
*@version 1.0
*@date 2016-07-19 15:26:10
*/
public interface ModelService extends BaseService<Model, Long> {
    /**
     * 生成的列表分页查询方法
     * @param modelCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author code generator
     * @date 2016-07-19 15:26:10
     */
    Page<Model> list(ModelCondition modelCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param bean Model类
     * @return List<Model> 查询的结果集
     * @author code generator
     * @date 2016-07-19 15:26:10
     */
    public List<Model> list(ModelCondition model);

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
     * 根据项目Id和数据库表获得对应Model的配置信息
     * @param projectId
     * @param db
     * @param table
     * @return
     */
	Model findBy(Long projectId, String table);
}