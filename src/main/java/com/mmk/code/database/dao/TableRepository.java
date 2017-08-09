package com.mmk.code.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.code.database.model.DbTable;

/**
*@Title: TableRepository
*@Description: 表 数据资源层
*@author code generator
*@version 1.0
*@date 2016-07-19 17:15:43
*/
public interface TableRepository extends JpaRepository<DbTable, Long>{


}