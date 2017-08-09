/*
 * File: app/view/CodeViewController.js
 *
 * This file was generated by Sencha Architect version 3.2.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 5.1.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 5.1.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('Code.view.CodeViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.code',

    buildData: function(fields) {
        var validate = true;
        var message = "";
        var projectform = this.getReferences().projectForm;
        var tableform = this.getReferences().tableForm;

        if(!projectform.isValid()){
            validate = false;
            message += "项目配置有误<br/>";
        }
        if(!tableform.isValid()){
            validate = false;
            message += "模型参数有误<br/>";
        }

        var columns = Ext.getStore("ColumnStore").getData();


        var projectData = projectform.getValues();
        var tableData = tableform.getValues();
        var data = {};

        data.project = projectData;
        data.model = tableData;

        data.fieldList = [];

        columns.each(function(item,index,len){

            if(item.get("COMMENTS")===null||item.get("COMMENTS")=== 'undefined' || item.get("COMMENTS") ==='' ){
                message +=  "字段："+item.get("FIELD_NAME") + "的注释没有写<br/>";
                validate = false;
            }
            var field = item.getData();
            field.id = "";
            data.fieldList.push(field);
        });


        return {params:data,validate:validate,message:message};
    },

    validateChange: function(field, newValue, oldValue, eOpts) {

    },

    onButtonClick: function(button, e, eOpts) {
        Ext.Msg.alert("尚未实现","尚未实现");
    },

    loadColumn: function(dataview, record, item, index, e, eOpts) {

        var model = this.getViewModel();
        var projectForm = this.lookupReference("projectForm");
        var projectId = projectForm.getValues().id;

        Ext.Ajax.request({
            url:SERVER+'/model/info',
            params:{'projectId':projectId,'db':record.get("TABLE_SCHEMA"),"table":record.get("TABLE_NAME")},
            success:function(response){
                var text = response.responseText;
                var object = Ext.JSON.decode(text);
                if(!object.packageName){
                    object.packageName=model.get("project").groupPackage;
                }
                if(!object.modulePackage){
                    object.modulePackage=model.get("project").modulePackage;
                }
                model.set("model",object);

                var store = Ext.getStore("ColumnStore");
                store.getProxy().setExtraParams({modelId:object.id,'db':record.get("TABLE_SCHEMA"),"table":record.get("TABLE_NAME")});
                store.load();
            }
        });
    },

    showTables: function(field, newValue, oldValue, eOpts) {
        Ext.getStore("TableTreeStore").load({params:{"name":newValue}});
    },

    projectList: function(button, e, eOpts) {
        Ext.getCmp("codeviewport").getLayout().prev();
    },

    preview: function(button, e, eOpts) {
        var result = this.buildData();
        if(!result.validate){
            Ext.Msg.alert("校验出错",result.message);
            return ;
        }

        var projectForm = this.lookupReference("projectForm");
        var tableForm = this.lookupReference("tableForm");
        var columns = Ext.getStore("ColumnStore").getData();
        var fieldList = [];
        columns.each(function(item,index,len){
            var field = item.getData();
            if(isNaN(field.id)){
                field.id = null;
            }
            fieldList.push(field);
        });
        Ext.Ajax.request({
            url:SERVER+'/code/preview',
            jsonData:{project:projectForm.getValues(),model:tableForm.getValues(),fieldList:fieldList},
            success:function(response){
                var text = response.responseText;
                var data = Ext.JSON.decode(text);
                console.log("data",data);
                var window = Ext.widget("codeviewwindow");
                window.getViewModel().setData(data);
                window.show();
            }
        });
    },

    previewpage: function(button, e, eOpts) {
        var result = this.buildData();
        if(!result.validate){
            Ext.Msg.alert("校验出错",result.message);
            return ;
        }
        var projectForm = this.lookupReference("projectForm");
        var tableForm = this.lookupReference("tableForm");
        var columns = Ext.getStore("ColumnStore").getData();
        var fieldList = [];
        columns.each(function(item,index,len){
            var field = item.getData();
            if(isNaN(field.id)){
                field.id = null;
            }
            fieldList.push(field);
        });
        Ext.Ajax.request({
            url:'/code/preview',
            jsonData:{project:projectForm.getValues(),model:tableForm.getValues(),fieldList:fieldList},
            success:function(response){
                var text = response.responseText;
                var data = Ext.JSON.decode(text);
                var window = Ext.widget("pageviewwindow");
                window.getViewModel().setData(data);
                window.show();
            },
            failure:function(response){
                Ext.Msg.alert("提示","服务不可达");
            }
        });
    },

    buildCode: function(button, e, eOpts) {

        var result = this.buildData();
        if(!result.validate){
            Ext.Msg.alert("校验出错",result.message);
            return ;
        }

        Ext.Ajax.request({
            url:'/code/builde',
            jsonData:result.params,
            success:function(response){
                Ext.Msg.alert("操作结果",response.responseText);
            }
        });
    },

    saveBuildInfo: function(button, e, eOpts) {
        var projectForm = this.lookupReference("projectForm");
        var tableForm = this.lookupReference("tableForm");
        var columns = Ext.getStore("ColumnStore").getData();
        var fieldList = [];
        columns.each(function(item,index,len){
            var field = item.getData();
            if(isNaN(field.id)){
                field.id = null;
            }
            fieldList.push(field);
        });
        Ext.Ajax.request({
            url:SERVER+'/code/save',
            jsonData:{project:projectForm.getValues(),model:tableForm.getValues(),fieldList:fieldList},
            success: function(form, action) {
                Ext.toast({
                    html: '数据保存成功',
                    title: '成功',
                    width: 200,
                    align: 'tr'
                });
                Ext.getStore("ColumnStore").reload();
            },
            failure:function(form,action){
                Ext.toast({
                    html: '数据保存失败',
                    title: '失败',
                    width: 200,
                    align: 'tr'
                });
            }
        });
    }

});
