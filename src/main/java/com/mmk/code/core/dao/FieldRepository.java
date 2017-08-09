package com.mmk.code.core.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.code.core.model.Field;

/**
*@Title: FieldRepository
*@Description: 字段 数据资源层
*@author code generator
*@version 1.0
*@date 2016-07-22 09:49:51
*/
public interface FieldRepository extends JpaRepository<Field, Long>{


}