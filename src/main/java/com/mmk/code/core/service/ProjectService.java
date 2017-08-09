package com.mmk.code.core.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.code.core.model.Project;
import com.mmk.code.core.condition.ProjectCondition;

/**
*@Title: ProjectService
*@Description: 项目 业务服务层接口
*@author code generator
*@version 1.0
*@date 2016-07-19 14:16:56
*/
public interface ProjectService extends BaseService<Project, Long> {
    /**
     * 生成的列表分页查询方法
     * @param projectCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author code generator
     * @date 2016-07-19 14:16:56
     */
    Page<Project> list(ProjectCondition projectCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param bean Project类
     * @return List<Project> 查询的结果集
     * @author code generator
     * @date 2016-07-19 14:16:56
     */
    public List<Project> list(ProjectCondition project);

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