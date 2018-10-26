package study.springboot.myspringboot.datasourse;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/2516:26
 */
@Configuration
public class MultiDataSourceConfig {
    //数据源1-引用配置:spring.datasource.primary
    @Bean(name = "pmsDataSource")
    @Qualifier("pmsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.pms")
    public DataSource pmsDataSource() {
        return DataSourceBuilder.create().build();
    }

    //数据源2-引用配置:spring.datasource.secondary
    @Bean(name = "mtsDataSource")
    @Qualifier("mtsDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mts")
    public DataSource mtsDataSource() {
        return DataSourceBuilder.create().build();
    }
}
