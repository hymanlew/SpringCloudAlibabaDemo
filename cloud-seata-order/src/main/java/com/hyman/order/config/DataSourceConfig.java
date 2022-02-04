package com.hyman.order.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 使用 seata 对数据源进行代理
 */
@Slf4j
@Configuration
@ServletComponentScan
public class DataSourceConfig {

    @Resource
    private Environment env;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    /**
     * datasource公用部分配置
     *
     * @param datasource
     */
    private void configCommonPartDataSource(DruidDataSource datasource) {
        //config
        datasource.setUrl(env.getProperty("spring.datasource.order.url"));
        datasource.setUsername(env.getProperty("spring.datasource.order.username"));
        datasource.setPassword(env.getProperty("spring.datasource.order.password"));
        datasource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));

        datasource.setInitialSize(env.getProperty("spring.datasource.initialSize", Integer.class));
        datasource.setMinIdle(env.getProperty("spring.datasource.minIdle", Integer.class));
        datasource.setMaxActive(env.getProperty("spring.datasource.maxActive", Integer.class));
        datasource.setMaxWait(env.getProperty("spring.datasource.maxWait", Integer.class));
        datasource.setTimeBetweenEvictionRunsMillis(env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis", Integer.class));
        datasource.setMinEvictableIdleTimeMillis(env.getProperty("spring.datasource.minEvictableIdleTimeMillis", Integer.class));
        datasource.setValidationQuery(env.getProperty("spring.datasource.validationQuery"));
        datasource.setTestWhileIdle(env.getProperty("spring.datasource.testWhileIdle", Boolean.class));
        datasource.setTestOnBorrow(env.getProperty("spring.datasource.testOnBorrow", Boolean.class));
        datasource.setTestOnReturn(env.getProperty("spring.datasource.testOnReturn", Boolean.class));
        datasource.setPoolPreparedStatements(env.getProperty("spring.datasource.poolPreparedStatements", Boolean.class));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(env.getProperty("spring.datasource.maxPoolPreparedStatementPerConnectionSize", Integer.class));
        try {
            datasource.setFilters(env.getProperty("spring.datasource.filters"));
        } catch (SQLException e) {
            log.error("druid config initialization filter", e);
        }
        datasource.setConnectionProperties(env.getProperty("spring.datasource.connectionProperties"));
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource orderDataSource() {
        return new DruidDataSource();
    }

    /**
     * 创建 seata 数据源代理
     */
    @Bean
    @Primary
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

    /**
     * 创建工厂
     *
     * @param dataSourceProxy
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSourceProxy);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        bean.setTransactionFactory(new SpringManagedTransactionFactory());
        return bean.getObject();
    }

    /**
     * 创建事务
     *
     * @param dataSource
     * @return DataSourceTransactionManager
     */
    @Bean
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
