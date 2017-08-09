package com.mmk.code.core.web;

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
import com.mmk.code.common.PropertyNameTools;
import com.mmk.code.common.SessionUtils;
import com.mmk.code.core.condition.ModelCondition;
import com.mmk.code.core.model.Model;
import com.mmk.code.core.service.ModelService;
import com.mmk.code.database.service.TableService;

/**
*@Title: ModelController
*@Description: 实体模型 的web控制层
*@author code generator
*@version 1.0
*@date 2016-07-19 15:26:10
*/
@RestController
public class ModelController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private ModelService modelService;
	
	@Resource 
	private TableService tableService;

    /**
	 * 跳转至列表页面
	 * @param pageable model
	 * @return
	 * @author code generator
     * @date 2016-07-19 15:26:10
	 */
	@RequestMapping("/model/list")
	@ResponseBody
	public ExtJsPage<Model> list(ModelCondition modelCondition, ExtJsPageable pageable){		
	    log.info("实体模型列表查询");
		Page<Model> modelPage =modelService.list(modelCondition,pageable.pageable());		
		return  new ExtJsPage< Model >(modelPage);
	}
	
	
	/**
	 * 实体模型数据保存方法
	 * @param model
	 * @return model
	 * @author code generator
     * @date 2016-07-19 15:26:10
	 */
	@RequestMapping("/model/save")
	@ResponseBody
	public Model save(Model data){
		log.info("实体模型保存");
		return modelService.save(data);
	}
	
	/**
     * 实体模型数据批量保存方法
     * @param model
     * @return model
     * @author code generator
     * @date 2016-07-19 15:26:10
     */
    @RequestMapping("/model/saveAll")
    @ResponseBody
    public boolean save(@RequestBody List<Model> modelList){
        log.info("实体模型批量保存");
        try {
            modelService.save(modelList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return false;
        }
    }

	
	/**
	 * 跳转至详细信息页面
	 * @param page model
	 * @return
	 * @author code generator
     * @date 2016-07-19 15:26:10
	 */ 
	@RequestMapping("/model/details")
	@ResponseBody
	public Model details(Model model){
		log.info("实体模型详细信息");
		model = modelService.find(model.getId());
		return model;
	}
	
	@RequestMapping("/model/info")
	@ResponseBody
	public Map<String, Object> info(Long projectId,String db,String table){
		log.info("实体模型详细信息");
		Map<String, Object> tableComment = tableService.tableComment(db, table);
		tableComment.put("author", SessionUtils.getSession().getAttribute("username"));
		tableComment.put("MODEL", PropertyNameTools.table2Model(table));
		return tableComment;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param page model
	 * @return
	 * @author code generator
     * @date 2016-07-19 15:26:10
	 */
	@RequestMapping("/model/delete")
	public boolean delete(Model model){
		log.info("实体模型删除");
        try {
            modelService.delete(model);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
	}
	
	/**
     * 批量删除数据操作组方法
     * @param page model
     * @return ture or false 如果成功返回true ,出现错误返回false
     * @author code generator
     * @date 2016-07-19 15:26:10
     */
    @RequestMapping("/model/deleteAll")
    public boolean delete(List<Model> modelList){
        log.info("实体模型批量删除");
        try {
            modelService.delete(modelList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
	
}