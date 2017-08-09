package com.mmk.code.core.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.code.core.model.Field;
import com.mmk.code.core.condition.FieldCondition;

/**
*@Title: FieldService
*@Description: 字段 业务服务层接口
*@author code generator
*@version 1.0
*@date 2016-07-22 09:49:51
*/
public interface FieldService extends BaseService<Field, Long> {
    /**
     * 生成的列表分页查询方法
     * @param fieldCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author code generator
     * @date 2016-07-22 09:49:51
     */
    Page<Field> list(FieldCondition fieldCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param bean Field类
     * @return List<Field> 查询的结果集
     * @author code generator
     * @date 2016-07-22 09:49:51
     */
    public List<Field> list(FieldCondition field);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Field 中的某个字段
     * @return Field 返回符合条件的结果，如果没有返回null
     * @author code generator
     * @date 2016-07-22 09:49:51
     * 
     */
    Field findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Field 中的某个字段
     * @return List<Field> 返回符合条件的所有结果
     * @author code generator
     * @date 2016-07-22 09:49:51
     * 
     */
    List<Field> findAllBy(String field,Object value);

    /**
     * 根据模型Id和column获得对应的字段
     * @param modelId
     * @param column
     * @return 符合条件的字段
     */
	Field findByModelIdAndColumn(Long modelId, String column);
}