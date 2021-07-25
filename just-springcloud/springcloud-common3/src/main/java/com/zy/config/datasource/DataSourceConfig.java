//package com.zy.config.datasource;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//
///**
// * 此文件用来配置系统的数据源（javax.sql.Datasource)
// * 
// * 可在此文件中配置一个或多个数据源，其中有一个为首要数据源（@Primary标记)
// * 
// */
//@Configuration
////@Profile({"dev"})
//public class DataSourceConfig {
//	@Bean(name = "primaryDataSource")
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
////    @Bean(name = "secondaryDataSource")
////    @ConfigurationProperties(prefix="spring.datasource")
////    public DataSource secondaryDataSource() {
////        return DataSourceBuilder.create().build();
////    }
//}