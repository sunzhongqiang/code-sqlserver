/*
 * File: app/view/PageViewWindow.js
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

Ext.define('Code.view.PageViewWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.pageviewwindow',

    requires: [
        'Code.view.PageViewWindowViewModel',
        'Ext.tab.Panel',
        'Ext.tab.Tab'
    ],

    viewModel: {
        type: 'pageviewwindow'
    },
    height: 762,
    width: 918,
    layout: 'fit',
    title: '页面预览',

    items: [
        {
            xtype: 'tabpanel',
            title: '',
            activeTab: 0,
            tabPosition: 'bottom',
            items: [
                {
                    xtype: 'panel',
                    title: '查询列表页面',
                    bind: {
                        html: '{list}'
                    }
                },
                {
                    xtype: 'panel',
                    title: '编辑页面',
                    bind: {
                        html: '{form}'
                    }
                },
                {
                    xtype: 'panel',
                    title: '详细页面',
                    bind: {
                        html: '{details}'
                    }
                },
                {
                    xtype: 'panel',
                    html: '<iframe src="/code/previewHtml/list" width="100%"  height="100%"></iframe>',
                    title: '查询列表页面Code'
                },
                {
                    xtype: 'panel',
                    html: '<iframe src="/code/previewHtml/form" width="100%"  height="100%"></iframe>',
                    title: '编辑页面Code'
                },
                {
                    xtype: 'panel',
                    html: '<iframe src="/code/previewHtml/details" width="100%"  height="100%"></iframe>',
                    title: '详细页面Code'
                },
                {
                    xtype: 'panel',
                    html: '<iframe src="/code/preview/validateJs" width="100%"  height="100%"></iframe>',
                    title: '校验JsCode'
                }
            ]
        }
    ]

});