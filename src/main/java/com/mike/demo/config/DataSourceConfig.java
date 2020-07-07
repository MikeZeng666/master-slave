package com.mike.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mike.demo.bean.MyRoutingDataSource;
import com.mike.demo.enums.DBTypeEnum;

@Configuration
public class DataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.master")
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}
	@Bean
	@ConfigurationProperties("spring.datasource.slave")
	public DataSource slaveDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public DataSource myRoutingDataSource(
			@Qualifier("masterDataSource") DataSource masterDS,
			@Qualifier("slaveDataSource") DataSource slaveDS) {
		Map<Object, Object> targetDS = new HashMap<>();
		targetDS.put(DBTypeEnum.MASTER, masterDS);
		targetDS.put(DBTypeEnum.SLAVE, slaveDS);
		MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
		myRoutingDataSource.setDefaultTargetDataSource(masterDS);
		myRoutingDataSource.setTargetDataSources(targetDS);
		return myRoutingDataSource;
	}
}
