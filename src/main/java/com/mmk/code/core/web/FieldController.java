package com.mmk.code.core.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.code.common.ExtJsPage;
import com.mmk.code.common.ExtJsPageable;
import com.mmk.code.core.condition.FieldCondition;
import com.mmk.code.core.model.Field;
import com.mmk.code.core.service.FieldService;
import com.mmk.code.database.service.TableService;

/**
*@Title: FieldController
*@Description: 字段 的web控制层
*@author code generator
*@version 1.0
*@date 2016-07-22 09:49:51
*/
@RestController
public class FieldController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private FieldService fieldService;
	@Resource 
	private TableService tableService;

    /**
	 * 跳转至列表页面
	 * @param pageable field
	 * @return
	 * @author code generator
     * @date 2016-07-22 09:49:51
	 */
	@RequestMapping("/field/list")
	@ResponseBody
	public ExtJsPage<Field> list(FieldCondition fieldCondition, ExtJsPageable pageable){		
	    log.info("字段列表查询");
		Page<Field> fieldPage =fieldService.list(fieldCondition,pageable.pageable());		
		return  new ExtJsPage< Field >(fieldPage);
	}
	
	
	/**
	 * 字段数据保存方法
	 * @param field
	 * @return field
	 * @author code generator
     * @date 2016-07-22 09:49:51
	 */
	@RequestMapping("/field/save")
	@ResponseBody
	public Field save(Field field){
		log.info("字段保存");
		return fieldService.save(field);
	}
	/**
	 * 根据模型加载fieldList
	 * @param field
	 * @return field
	 * @author code generator
     * @date 2016-07-22 09:49:51
	 */
	@RequestMapping("/field/loadByModelId")
	@ResponseBody
	public List<Map<String, Object>> loadByModelId(Long modelId,String db,String table){
		log.info("根据模型加载fieldList");
		List<Map<String, Object>> columnList = tableService.showDetails(db,table);
		if(modelId!=null){
			for (Map<String, Object> map : columnList) {
				String column = MapUtils.getString(map, "columnName");
				Field field = fieldService.findByModelIdAndColumn(modelId, column);
				if(field!=null){
					map.put("id", field.getId());
					map.put("existsMethod", field.getExistsMethod());
					map.put("findBy", field.getFindBy());
					map.put("findAllBy", field.getFindAllBy());
					map.put("listShow", field.getListShow());
					map.put("matchType", field.getMatchType());
					map.put("inputType", field.getInputType());
					map.put("validate", field.getValidate());
				}
			}
		}
		return columnList ;
	}
	
	
	/**
     * 字段数据批量保存方法
     * @param field
     * @return field
     * @author code generator
     * @date 2016-07-22 09:49:51
     */
    @RequestMapping("/field/saveAll")
    @ResponseBody
    public boolean save(@RequestBody List<Field> fieldList){
        log.info("字段批量保存");
        try {
            fieldService.save(fieldList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return false;
        }
    }

	
	/**
	 * 跳转至详细信息页面
	 * @param page field
	 * @return
	 * @author code generator
     * @date 2016-07-22 09:49:51
	 */ 
	@RequestMapping("/field/details")
	@ResponseBody
	public Field details(Field field){
		log.info("字段详细信息");
		field = fieldService.find(field.getId());
		return field;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param page field
	 * @return
	 * @author code generator
     * @date 2016-07-22 09:49:51
	 */
	@RequestMapping("/field/delete")
	public boolean delete(Field field){
		log.info("字段删除");
        try {
            fieldService.delete(field);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
	}
	
	/**
     * 批量删除数据操作组方法
     * @param page field
     * @return ture or false 如果成功返回true ,出现错误返回false
     * @author code generator
     * @date 2016-07-22 09:49:51
     */
    @RequestMapping("/field/deleteAll")
    public boolean delete(List<Field> fieldList){
        log.info("字段批量删除");
        try {
            fieldService.delete(fieldList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
	
}