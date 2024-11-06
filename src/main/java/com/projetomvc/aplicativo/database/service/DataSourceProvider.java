package com.projetomvc.aplicativo.database.service;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {
    private static HikariDataSource dataSource;

    static {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(Config.getProperty("db.url"));
        config.setUsername(Config.getProperty("db.username"));
        config.setPassword(Config.getProperty("db.password"));
        config.setMaximumPoolSize(10); 

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}