package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/11/29
 * Time: 21:31
 * Description: No Description
 */

@Configuration
public class AlphaConfig {

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
