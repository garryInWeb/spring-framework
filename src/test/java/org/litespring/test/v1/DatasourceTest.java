package org.litespring.test.v1;

import org.junit.Before;
import org.junit.Test;
import org.litespring.service.datasource.v1.DatasourceService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zhengtengfei on 2019/2/21.
 */
public class DatasourceTest {

    DefaultListableBeanFactory factory;
    XmlBeanDefinitionReader reader;
    @Before
    public void setUp(){
        factory = new DefaultListableBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }
    @Test
    public void testBeanFactory() {

        reader.loadBeanDefinitions(new ClassPathResource("petstore-datasource-v1.xml"));
        factory.getBean("transactionManager");

        DriverManagerDataSource dataSource = (DriverManagerDataSource) factory.getBean("dataSource");
        factory.getBean("jdbcTemplate");
//            Connection connection = dataSource.getConnection();
        DatasourceService datasourceService = factory.getBean(DatasourceService.class);
        try {
            datasourceService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
