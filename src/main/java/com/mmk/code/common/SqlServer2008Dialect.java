package com.mmk.code.common;

import org.hibernate.dialect.SQLServer2008Dialect;


public class SqlServer2008Dialect extends SQLServer2008Dialect {
	
	public SqlServer2008Dialect() {  
        super();  
        registerHibernateType(1, "string");  
        registerHibernateType(-9, "string");  
        registerHibernateType(-16, "string");  
        registerHibernateType(3, "double");  
    }  

}
