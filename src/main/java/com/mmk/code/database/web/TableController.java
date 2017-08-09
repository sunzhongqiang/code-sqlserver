package com.mmk.code.database.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.code.common.PropertyNameTools;
import com.mmk.code.common.SessionUtils;
import com.mmk.code.core.service.ModelService;
import com.mmk.code.database.service.TableService;

/**
*@Title: TableController
*@Description: 表 的web控制层
*@author code generator
*@version 1.0
*@date 2016-07-19 17:15:43
*/
@RestController
public class TableController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private TableService tableService;

	/**
	 * 根据数据库获取数据库的表
	 * @param name
	 * @return
	 */
	@RequestMapping("/tables")
	@ResponseBody
	public List<Map<String,Object>>  list(String name){
		log.info("遍历数据库中的表");
		List<Map<String, Object>> tableList = tableService.findAllByDb(name);
		return tableList;
	}
	
	
	@RequestMapping("/table-info")
	@ResponseBody
	public List<Map<String,Object>> info(String db,String table){
		log.info("显示数据库表字段的详细信息");
		return tableService.showDetails(db,table);
	}
	
	@RequestMapping("/table-comments")
	@ResponseBody
	public Map<String,Object> comments(String db,String table){
		log.info("获得表的备注一些额外信息");
		Map<String, Object> tableComment = tableService.tableComment(db, table);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("author", SessionUtils.getSession().getAttribute("username"));
		result.put("TABLE_NAME", tableComment.get("TABLE_NAME"));
		result.put("TABLE_COMMENT", tableComment.get("TABLE_COMMENT"));
		result.put("TABLE_ROWS",tableComment.get("TABLE_ROWS"));
		result.put("AUTO_INCREMENT", tableComment.get("AUTO_INCREMENT"));
		result.put("MODEL", PropertyNameTools.table2Model(MapUtils.getString(tableComment, "TABLE_NAME")));
		return result ;
	}
	
}