package com.mmk.code.core.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.code.core.condition.FieldCondition;
import com.mmk.code.core.model.Field;
/**
*@Title: FieldDao
*@Description: 字段 数据持久层接口
*@author code generator
*@version 1.0
*@date 2016-07-22 09:49:51
* Modified By
* Modified Date
*/
public interface FieldDao extends SpringDataQueryDao<Field>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param model Field类
     * @param page 传入的分页对象
     * @return Page<Field> 查询的结果集
     * @author code generator
     * @date 2016-07-22 09:49:51
     * 
     */
    Page<Field> list(FieldCondition field,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param bean Field类
     * @return List<Field> 查询的结果集
     * @author code generator
     * @date 2016-07-22 09:49:51
     */
    List<Field> list(FieldCondition field);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param model Field类
     * @param page 传入的分页对象
     * @return Page<Field> 查询的结果集
     * @author code generator
     * @date 2016-07-22 09:49:51
     * 
     */
    Page< Map<String,Object>> listBySql(FieldCondition field,Pageable pageable);
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
     * 根据给定的字段和属性值，获得符合条件的字段
     * @param modelId
     * @param column
     * @return
     */
	Field findByModelIdAndColumn(Long modelId, String column);
    
    

}