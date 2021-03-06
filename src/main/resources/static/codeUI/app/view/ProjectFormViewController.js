/*
 * File: app/view/ProjectFormViewController.js
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

Ext.define('Code.view.ProjectFormViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.projectform',

    save: function(button, e, eOpts) {
        var data = button.up("form").submit({
            url:SERVER+'/project/save',
            success: function(form, action) {
                Ext.Msg.alert('项目保存成功', action.result.model.projectName);
                Ext.getStore("ProjectStore").load({url:SERVER+'/project/list'});
            }
        });
    }

});
