package com.mmk.code.common;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * velocity模版处理类
 * @author Administrator
 * 使用步骤
 * 1、TemplateTool tm=new TemplateTool("org/demo/hello.vm");   实例对象
 * 2、tm.put("name", "sunny");  
 */
public class TemplateTool {
	
	private Template t = null;
	private VelocityContext context =null;
	
	public TemplateTool(String templatePath){
		initVelocity(templatePath);
	}
	
	public void initVelocity(String templatePath){
		VelocityEngine ve = new VelocityEngine();   
        ve.setProperty(Velocity.RESOURCE_LOADER, "class");   
        ve.setProperty("class.resource.loader.class",   
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");   
        ve.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogChute");//关闭Velocity日志
        ve.init();   
        t = ve.getTemplate(templatePath,"UTF-8");   
        context = new VelocityContext();
	}
	
	public void put(String key,Object value){
		context.put(key, value);
	}
	
	public String getResult(){
		StringWriter writer = new StringWriter();   
        t.merge(context, writer);   
        return writer.toString();
	}
}
