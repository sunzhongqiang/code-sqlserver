package com.mmk.code.database.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.code.database.service.DbService;

/**
*@Title: DbController
*@Description: 数据库 的web控制层
*@author code generator
*@version 1.0
*@date 2016-07-19 17:14:33
*/
@RestController
public class DbController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private DbService dbService;

	/**
	 * @Description 获取数据库的所有数据库
	 * @return
	 */
	@RequestMapping("/db")
	@ResponseBody
	public List<Map<String,Object>> list(){
		log.info("遍历数据库，除了关键数据库");
		return dbService.dbList();
	}
	
}