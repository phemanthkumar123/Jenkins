package com.rto.util;

import org.apache.log4j.Logger;

public class DateConverter {
	
	private static final Logger logger=Logger.getLogger(DateConverter.class);

	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		logger.info("entered into convertUtilToSql() method");
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        logger.info("exiting from convertUtilToSql() method");
        return sDate;
    }
}
