package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/12/7
 * Time: 15:10
 * Description: No Description
 */

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class LoggerTest {

    private static final Logger logger= LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void testLogger(){
        System.out.println(logger.getName());
        logger.debug("debug logger");
        logger.info("info logger");
        logger.warn("warn logger");
        logger.error("error logger");
    }
}
