package study.springboot.myspringboot.datasourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/2516:59
 */
/**
 * 注入JPA:
 * entityManagerFactory :  entityManagerFactorySecondary
 * transactionManager   :  transactionManagerSecondary
 * basePackages         :  com.example.domain.second
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactorySecondary",
        transactionManagerRef="transactionManagerSecondary",
        basePackages= {"study.springboot.myspringboot.bean.pms"}) //设置Repository所在位置
public class PMSConfig {

    /**
     * 自动注入 DataSourceConfig 类中的数据源配置文件secondaryDataSource
     * 实例化DataSource(secondaryDataSource)
     */
    @Autowired
    @Qualifier("pmsDataSource")
    private DataSource pmsDataSource;

    /**
     * 创建 EntityManager :
     *      根据EntityManagerFactoryBuilder 创建 EntityManager
     * @param builder EntityManagerFactoryBuilder
     * @return
     */
    @Bean(name = "entityManagerSecondary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
    }

    /**
     * 根据当前数据源配置,创建entityManagerFactory
     * @param builder
     * @return
     */
    @Bean(name = "entityManagerFactorySecondary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(pmsDataSource)
                .properties(getVendorProperties(pmsDataSource))
                .packages("study.springboot.myspringboot.bean.pms") //设置实体类所在位置
                .persistenceUnit("secondaryPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return  null;
//        return jpaProperties.getHibernatePropertie
// s(dataSource);
    }

    /**
     * 根据entityManagerFactory(entityManagerFactorySecondary)生成transactionManager(transactionManagerSecondary)
     * @param builder PlatformTransactionManager
     * @return
     */
    @Bean(name = "transactionManagerSecondary")
    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }

}
