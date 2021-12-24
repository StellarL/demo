package com.example.demo.dao;

import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/11/29
 * Time: 21:12
 * Description: No Description
 */

@Repository("alphaDaoHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
