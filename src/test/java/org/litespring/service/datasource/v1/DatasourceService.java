package org.litespring.service.datasource.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zhengtengfei on 2019/2/21.
 */
@Service
public class DatasourceService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void test() throws Exception {
        String sql = "UPDATE score SET age=age+1 WHERE id=2";
        int users = jdbcTemplate.update(sql);
        System.out.println(users);
        throw new Exception("gg");
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
