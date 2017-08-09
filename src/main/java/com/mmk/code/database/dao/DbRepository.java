package com.mmk.code.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.code.database.model.Db;

/**
*@Title: DbRepository
*@Description: 数据库 数据资源层
*@author code generator
*@version 1.0
*@date 2016-07-19 17:14:33
*/
public interface DbRepository extends JpaRepository<Db, Long>{


}