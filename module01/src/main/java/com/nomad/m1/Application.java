package com.nomad.m1;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;


@SpringBootApplication
@PropertySource("classpath:application.yml")
public class Application {

    @Autowired
    private Environment env;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "abis-database")
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setJdbcUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.user"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));
        dataSource.setAutoCommit(true);
        dataSource.setMaximumPoolSize(env.getRequiredProperty("db.maxPoolsize", Integer.class));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("abis-database") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setFetchSize(env.getRequiredProperty("db.fetchSize", Integer.class));
        return jdbcTemplate;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
