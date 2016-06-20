package milliongravity.common.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by hongtao
 */
@Configuration
@ImportResource("classpath:ApplicationContext.xml")
@MapperScan("milliongravity.dao")
public class DataSourceConfig {

    private @Value("${jdbc.driverClassName}") String jdbcDriver;
    private @Value("${jdbc.url}") String jdbcUrl;
    private @Value("${jdbc.username}") String username;
    private @Value("${jdbc.password}") String password;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }
}
