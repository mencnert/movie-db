package com.mencner.moviedb.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource getDataSource() {
        PoolProperties pp = new PoolProperties();
        pp.setUrl("jdbc:postgresql:192.168.0.14:5432/postgres");
        pp.setDriverClassName("org.postgresql.Driver");
        pp.setUsername("postgres");
        pp.setPassword("BananaPower");
        pp.setValidationQuery("SELECT 1");
        pp.setTestOnBorrow(true);

        return new DataSource(pp);
    }
}
