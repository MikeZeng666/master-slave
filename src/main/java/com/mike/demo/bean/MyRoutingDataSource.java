package com.mike.demo.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import com.mike.demo.enums.DBTypeEnum;

public class MyRoutingDataSource extends AbstractRoutingDataSource{

	@Nullable
	@Override
	protected Object determineCurrentLookupKey() {
		if (DBContextHolder.get() == DBTypeEnum.MASTER) {
			System.out.println("当前数据库为Master");
		}else {
			System.out.println("当前数据库为Slave");
		}
		return DBContextHolder.get();
	}

}
