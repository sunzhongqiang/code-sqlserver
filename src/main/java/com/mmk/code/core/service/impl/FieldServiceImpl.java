package com.mmk.code.core.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.code.core.dao.FieldRepository;
import com.mmk.code.core.model.Field;
import com.mmk.code.core.condition.FieldCondition;
import com.mmk.code.core.service.FieldService;
import com.mmk.code.core.dao.FieldDao;
/**
*@Title: FieldServiceImpl
*@Description: 字段 业务服务层实现
*@author code generator
*@version 1.0
*@date 2016-07-22 09:49:51
*/
@Service
public class FieldServiceImpl extends BaseServiceImpl<Field, Long> implements FieldService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private FieldDao fieldDao;
    
    private FieldRepository fieldRepository;
    /**
    *构造方法
    */
    @Autowired
    public FieldServiceImpl( FieldRepository fieldRepository) {
        super(fieldRepository);
        this.fieldRepository = fieldRepository;
    }

    @Override
    public Page<Field> list(FieldCondition fieldCondition, Pageable pageable) {
        log.info("字段查询列表");
        return fieldDao.list(fieldCondition, pageable);
    }
    
    @Override
    public List<Field> list(FieldCondition fieldCondition) {
        log.info("字段查询列表无分页");
        return fieldDao.list(fieldCondition);
    }

    @Override 
    public Field findBy(String field,Object value){
        log.info("字段根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return fieldDao.findBy(field,value);
    }
    
    @Override 
    public List<Field> findAllBy(String field,Object value){
        log.info("字段根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return fieldDao.findAllBy(field,value);
    }

	@Override
	public Field findByModelIdAndColumn(Long modelId, String column) {
		log.info("根据modelId 和 column进行查询符合条件的记录");
        return fieldDao.findByModelIdAndColumn(modelId,column);
	}
}