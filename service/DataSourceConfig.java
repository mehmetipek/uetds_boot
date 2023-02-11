package com.arma.uetds_boot.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;

	@Bean
    public DataSource createDataSource() throws Exception {
		String con_url=url+"&user="+username+"&password="+password;
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl(con_url);
        ds.setDriverClass("org.postgresql.Driver");
        return ds;
    }

}
