package com.example.demo;

import com.example.demo.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/12/7
 * Time: 19:38
 * Description: No Description
 */

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail(){
        mailClient.sendEmil("13688427004@163.com","hah","内容内容");
    }

    @Test
    public void testHtmlMail(){
        Context context =new Context();
        context.setVariable("username","张三");
        String content=templateEngine.process("/mail/demo",context);
        System.out.println(content);
        mailClient.sendEmil("13688427004@163.com","张三",content);
    }
}
