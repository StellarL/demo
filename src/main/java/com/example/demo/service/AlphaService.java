package com.example.demo.service;

import com.example.demo.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/11/29
 * Time: 21:21
 * Description: No Description
 */

@Service
//@Scope("prototype")
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;


    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct
//    方法在构造器之后调用
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁AlphaService");
    }


    public String find(){
        return alphaDao.select();
    }
}
