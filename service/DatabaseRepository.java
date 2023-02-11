package com.arma.uetds_boot.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Service
public class DatabaseRepository {
	
	@Autowired
	DataSource dataSource;

	public void printC3P0ConnectionDetails()
    {
        ComboPooledDataSource ds = (ComboPooledDataSource) dataSource;
        System.out.println("#################################### Instace of DBCP basic data source: " + ds);
        System.out.println("Connection Pool size : " + ds.getMaxPoolSize());
        System.out.println("Min connection pool size: " + ds.getMinPoolSize());
        System.out.println("Max statements: " + ds.getMaxStatements());
        System.out.println("Url: " + ds.getJdbcUrl());
    }
}
