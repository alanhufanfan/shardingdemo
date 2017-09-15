package com.jinyu.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.jinyu.algorithm.ModuloDatabaseShardingAlgorithm;
import com.jinyu.algorithm.ModuloTableShardingAlgorithm;
import org.apache.commons.dbcp.BasicDataSource;

import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;

/**
 * sharding jdbc demo
 */
public class ShardingJdbcDemo {

    /**
     * 创建数据源
     *
     * @param dataSourceName
     * @return
     */
    private static DataSource createDataSource(String dataSourceName) {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl(String.format("jdbc:mysql://172.16.103.217:3306/%s?characterEncoding=utf-8", dataSourceName));
        result.setUsername("root");
        result.setPassword("gl!QAZxsw2");
        return result;
    }


    public static void main(String[] args) throws SQLException {

        //数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("sharding_0", createDataSource("crm")); //库1
        dataSourceMap.put("sharding_1", createDataSource("crm")); //库2
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap);


        //表规则
        TableRule orderTableRule = TableRule.builder("t_order").actualTables(Arrays.asList("t_order_0", "t_order_1"))
                .dataSourceRule(dataSourceRule)     // 数据源
                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm())) //库策略
                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm()))         //表策略
                .build();

        TableRule orderItemTableRule = TableRule.builder("t_order_item").actualTables(Arrays.asList("t_order_item_0", "t_order_item_1"))
                .dataSourceRule(dataSourceRule)
                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm()))
                .build();


        // 库规则
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(orderTableRule, orderItemTableRule))      //添加所有表规则
                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm()))
                .build();


        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        String sql = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.user_id=? AND o.order_id=?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, 10);
                pstmt.setInt(2, 1001);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getInt(2));
                    System.out.println(rs.getInt(3));
                }
            }
        }
    }



}