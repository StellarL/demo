package com.example.demo.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/11/29
 * Time: 21:15
 * Description: No Description
 */
@Repository
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao{


    @Override
    public String select() {
        return "Mybatis";
    }
}
