package com.eshop.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by raks on 05.11.16.
 */
@Configuration
@MapperScan("com.eshop.mapper")
public class MybatisConfig {
    @Autowired
    DataSource dataSource;

    @Bean(name="JdbcTemplate")
    public SqlSessionFactory jdbcOperations() throws Exception {
        SqlSessionFactoryBean session = new SqlSessionFactoryBean();
        session.setDataSource(dataSource);
        return session.getObject();
    }
}
