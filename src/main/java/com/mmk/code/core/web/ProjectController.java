package com.mmk.code.core.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.code.common.ExtJsPage;
import com.mmk.code.common.ExtJsPageable;
import com.mmk.code.core.condition.ProjectCondition;
import com.mmk.code.core.model.Project;
import com.mmk.code.core.service.ProjectService;

/**
*@Title: ProjectController
*@Description: 项目 的web控制层
*@author code generator
*@version 1.0
*@date 2016-07-19 14:16:56
*/
@RestController
public class ProjectController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private ProjectService projectService;

    /**
	 * 跳转至列表页面
	 * @param pageable project
	 * @return
	 * @author code generator
     * @date 2016-07-19 14:16:56
	 */
	@RequestMapping("/project/list")
	@ResponseBody
	public ExtJsPage<Project> list(ProjectCondition projectCondition, ExtJsPageable pageable){		
	    log.info("项目列表查询");
		Page<Project> projectPage =projectService.list(projectCondition,pageable.pageable());		
		return  new ExtJsPage< Project >(projectPage);
	}
	
	
	/**
	 * 项目数据保存方法
	 * @param project
	 * @return project
	 * @author code generator
     * @date 2016-07-19 14:16:56
	 */
	@RequestMapping("/project/save")
	@ResponseBody
	public Map<String,Object> save(Project project){
		log.info("项目保存");
		project = projectService.save(project);
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("success", true);
		result.put("model", project);
		return result ;
	}
	
	/**
     * 项目数据批量保存方法
     * @param project
     * @return project
     * @author code generator
     * @date 2016-07-19 14:16:56
     */
    @RequestMapping("/project/saveAll")
    @ResponseBody
    public boolean save(@RequestBody List<Project> projectList){
        log.info("项目批量保存");
        try {
            projectService.save(projectList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return false;
        }
    }

	
	/**
	 * 跳转至详细信息页面
	 * @param page project
	 * @return
	 * @author code generator
     * @date 2016-07-19 14:16:56
	 */ 
	@RequestMapping("/project/details")
	@ResponseBody
	public Project details(Project project){
		log.info("项目详细信息");
		project = projectService.find(project.getId());
		return project;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param page project
	 * @return
	 * @author code generator
     * @date 2016-07-19 14:16:56
	 */
	@RequestMapping("/project/delete")
	public boolean delete(Project project){
		log.info("项目删除");
        try {
            projectService.delete(project);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
	}
	
	/**
     * 批量删除数据操作组方法
     * @param page project
     * @return ture or false 如果成功返回true ,出现错误返回false
     * @author code generator
     * @date 2016-07-19 14:16:56
     */
    @RequestMapping("/project/deleteAll")
    public boolean delete(List<Project> projectList){
        log.info("项目批量删除");
        try {
            projectService.delete(projectList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
	
}